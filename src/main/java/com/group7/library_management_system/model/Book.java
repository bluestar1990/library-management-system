package com.group7.library_management_system.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
public class Book {

	@Id
	@Field(name = "_id")
	private ObjectId id;

	@Field(name = "title")
	private String title;

	@Field(name = "isbn")
	private String isbn;

	@Field(name = "author_ids")
	private List<ObjectId> authorIds;

	@Field(name = "publisher_id")
	private ObjectId publisherId;

	@Field(name = "category_ids")
	private List<ObjectId> categoryId;

	@Field(name = "published_date")
	private Date publishedDate;

	@Field(name = "copies")
	private int copies;

	// Getters and Setters

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public List<ObjectId> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(List<ObjectId> authorIds) {
		this.authorIds = authorIds;
	}

	public ObjectId getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(ObjectId publisherId) {
		this.publisherId = publisherId;
	}

	public List<ObjectId> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<ObjectId> categoryId) {
		this.categoryId = categoryId;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
}