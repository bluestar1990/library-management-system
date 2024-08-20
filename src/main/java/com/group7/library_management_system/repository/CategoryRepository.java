package com.group7.library_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group7.library_management_system.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	// This interface provides CRUD operations by default
}
