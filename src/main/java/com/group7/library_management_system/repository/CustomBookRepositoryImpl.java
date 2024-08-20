package com.group7.library_management_system.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.group7.library_management_system.dto.BookDTO;
import com.group7.library_management_system.dto.BookSearchDTO;

@Repository
public class CustomBookRepositoryImpl implements CustomBookRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<BookDTO> findAllBooksWithAuthorsAndPublishers(BookSearchDTO bookSearchDTO) {
		// Lookup categories
		LookupOperation lookupCategories = LookupOperation.newLookup().from("categories").localField("category_ids")
				.foreignField("_id").as("category_details");

		// Lookup authors
		LookupOperation lookupAuthors = LookupOperation.newLookup().from("authors").localField("author_ids")
				.foreignField("_id").as("author_details");

		// Lookup publishers
		LookupOperation lookupPublishers = LookupOperation.newLookup().from("publishers").localField("publisher_id")
				.foreignField("_id").as("publisher_details");
		MatchOperation matchOperation = null;
		if (Objects.nonNull(bookSearchDTO)) {
			if (StringUtils.isNotEmpty(bookSearchDTO.getIsbnS())) {
				matchOperation = Aggregation.match(Criteria.where("isbn").regex(bookSearchDTO.getIsbnS(), "i"));
			}

			if (StringUtils.isNotEmpty(bookSearchDTO.getTitleS())) {
				matchOperation = Aggregation.match(Criteria.where("title").regex(bookSearchDTO.getTitleS(), "i"));
			}

			if (StringUtils.isNotEmpty(bookSearchDTO.get_id())) {
				matchOperation = Aggregation.match(Criteria.where("_id").is(bookSearchDTO.get_id()));
			}
		}

		if (Objects.isNull(matchOperation)) {
			matchOperation = Aggregation.match(Criteria.where("title").regex("", "i"));
		}

		// SortOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.DESC,
		// "published_date"));
		Aggregation aggregation = newAggregation(matchOperation, lookupCategories,
				// unwind("category_details", true), // Unwind category details
				lookupAuthors,
				// unwind("author_details", true), // Unwind category details
				lookupPublishers, unwind("publisher_details", true), // Unwind publisher details
				project("title", "isbn", "published_date", "copies", "author_ids", "publisher_id", "category_ids")
						.and("category_details.name").as("categoryName").and("author_details.name").as("authorNames")
						.and("publisher_details.name").as("publisherName"));

		AggregationResults<BookDTO> results = mongoTemplate.aggregate(aggregation, "books", BookDTO.class);

		List<BookDTO> bookDTO = results.getMappedResults();
		if (!CollectionUtils.isEmpty(bookDTO)) {
			if (Objects.nonNull(bookSearchDTO)) {
				if (StringUtils.isNotEmpty(bookSearchDTO.getAuthorS())) {
					bookDTO = bookDTO.stream().filter(b -> {
						boolean a = false;
						for (int i = 0; i < b.getAuthorNames().size(); i++) {
							if (!a && b.getAuthorNames().get(i).contains(bookSearchDTO.getAuthorS())) {
								a = true;
							}
						}
						return a;

					}).collect(Collectors.toList());
				}
				if (StringUtils.isNotEmpty(bookSearchDTO.getCategoryS())) {
					bookDTO = bookDTO.stream().filter(b -> {
						boolean a1 = false;
						for (int i = 0; i < b.getCategoryName().size(); i++) {
							if (!a1 && b.getCategoryName().get(i).contains(bookSearchDTO.getCategoryS())) {
								a1 = true;
							}
						}
						return a1;

					}).collect(Collectors.toList());
				}
				if (StringUtils.isNotEmpty(bookSearchDTO.getPublisherS())) {
					bookDTO = bookDTO.stream().filter(b -> {
						if (b.getPublisherName().contains(bookSearchDTO.getPublisherS())) {
							return true;
						}
						return false;
					}).collect(Collectors.toList());
				}
			}
			return bookDTO;
		} else {
			return bookDTO;
		}
	}
}
