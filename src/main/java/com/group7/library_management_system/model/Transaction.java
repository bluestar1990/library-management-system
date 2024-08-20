package com.group7.library_management_system.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "transactions")
public class Transaction {

	@Id
	@Field(name = "_id")
	private ObjectId id;

	@Indexed
	private ObjectId memberId;

	@Indexed
	private ObjectId bookId;

	private Date borrowDate;
	private Date dueDate;
	private Date returnDate;
	private String status; // borrowed, returned, overdue
}
