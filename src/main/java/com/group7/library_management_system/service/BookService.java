package com.group7.library_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.group7.library_management_system.dto.BookDTO;
import com.group7.library_management_system.dto.BookSearchDTO;
import com.group7.library_management_system.model.Book;
import com.group7.library_management_system.repository.BookRepository;
import com.group7.library_management_system.repository.CustomBookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CustomBookRepository customBookRepositoryImpl;

	public List<BookDTO> getAllBooks(BookSearchDTO bookSearchDTO) {
		return customBookRepositoryImpl.findAllBooksWithAuthorsAndPublishers(bookSearchDTO);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(List<String> ids) {

		// Create the query to match documents with string-based IDs
		Query query = new Query(Criteria.where("_id").in(ids));

		// Perform the delete operation
		mongoTemplate.remove(query, Book.class);
	}

	public Book findBookById(String id) {
		// Convert the string ID to ObjectId
		// ObjectId objectId = new ObjectId(id);

		// Create the query to match the ObjectId
		Query query = new Query(Criteria.where("_id").is(id));

		// Execute the query and return the result
		return mongoTemplate.findOne(query, Book.class);
	}
}
