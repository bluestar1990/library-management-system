package com.group7.library_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group7.library_management_system.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
	// This interface provides CRUD operations by default
}
