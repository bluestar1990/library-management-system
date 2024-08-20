package com.group7.library_management_system.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "publishers")
public class Publisher {

	@Id
	@Field(name = "_id")
	private ObjectId id;

	@Indexed
	private String name;

	private String address;
	private String contact;
	private List<ObjectId> books;
}
