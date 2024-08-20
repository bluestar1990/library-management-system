package com.group7.library_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group7.library_management_system.model.Publisher;

public interface PublisherRepository extends MongoRepository<Publisher, String> {
	// This interface provides CRUD operations by default
}
