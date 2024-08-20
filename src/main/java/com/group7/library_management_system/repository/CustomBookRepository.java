package com.group7.library_management_system.repository;

import java.util.List;

import com.group7.library_management_system.dto.BookDTO;
import com.group7.library_management_system.dto.BookSearchDTO;

public interface CustomBookRepository {
	List<BookDTO> findAllBooksWithAuthorsAndPublishers(BookSearchDTO bookSearchDTO);
}