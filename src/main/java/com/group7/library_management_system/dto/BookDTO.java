package com.group7.library_management_system.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookDTO {

	private String id;

	private String title;

	private String isbn;

	private List<String> author_ids;

	private String publisher_id;

	private List<String> category_ids;

	private Date published_date;

	private int copies;

	// Transient fields for aggregated data
	private List<String> categoryName;
	private List<String> authorNames;
	private String publisherName;

	// Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthorIds() {
		return author_ids;
	}

	public void setAuthorIds(List<String> authorIds) {
		this.author_ids = authorIds;
	}

	public String getPublisherId() {
		return publisher_id;
	}

	public void setPublisherId(String publisherId) {
		this.publisher_id = publisherId;
	}

	public List<String> getCategoryIds() {
		return category_ids;
	}

	public void setCategoryIds(List<String> categoryId) {
		this.category_ids = categoryId;
	}

	public Date getPublishedDate() {
		return published_date;
	}

	public void setPublishedDate(Date publishedDate) {
		this.published_date = publishedDate;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public List<String> getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(List<String> categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getAuthorNames() {
		return authorNames;
	}

	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
}
