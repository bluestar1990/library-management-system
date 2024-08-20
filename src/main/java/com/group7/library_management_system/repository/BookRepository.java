package com.group7.library_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group7.library_management_system.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}
