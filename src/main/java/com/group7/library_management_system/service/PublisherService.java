package com.group7.library_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.library_management_system.model.Publisher;
import com.group7.library_management_system.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}
}
