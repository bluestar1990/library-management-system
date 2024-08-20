package com.group7.library_management_system.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "members")
public class Member {

	@Id
	@Field(name = "_id")
	private ObjectId id;

	private String name;

	@Indexed(unique = true)
	private String membershipNumber;

	@Indexed
	private String email;

	private String phone;
	private String address;
	private List<BorrowedBook> borrowedBooks;
}
