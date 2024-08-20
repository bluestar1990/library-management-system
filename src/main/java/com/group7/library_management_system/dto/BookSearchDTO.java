package com.group7.library_management_system.dto;

import lombok.Data;

@Data
public class BookSearchDTO {

	private String isbnS;
	private String titleS;
	private String authorS;
	private String categoryS;
	private String publisherS;
	private String _id;
}
