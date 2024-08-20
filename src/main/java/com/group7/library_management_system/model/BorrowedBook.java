package com.group7.library_management_system.model;

import java.util.Date;

import lombok.Data;

@Data
public class BorrowedBook {
	private String bookId;
	private Date borrowDate;
	private Date dueDate;
}
