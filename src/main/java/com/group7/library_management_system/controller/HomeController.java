/**
 * 
 */
package com.group7.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group7.library_management_system.dto.BookDTO;
import com.group7.library_management_system.dto.BookSearchDTO;
import com.group7.library_management_system.dto.DeletingBookDTO;
import com.group7.library_management_system.model.Author;
import com.group7.library_management_system.model.Book;
import com.group7.library_management_system.model.Category;
import com.group7.library_management_system.model.Publisher;
import com.group7.library_management_system.service.AuthorService;
import com.group7.library_management_system.service.BookService;
import com.group7.library_management_system.service.CategoryService;
import com.group7.library_management_system.service.PublisherService;

/**
 * 
 */
@Controller
public class HomeController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public String bookController(Model model) {
		List<BookDTO> books = bookService.getAllBooks(null);
		model.addAttribute("books", books);

		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);

		List<Publisher> publishers = publisherService.getAllPublishers();
		model.addAttribute("publishers", publishers);

		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);

		BookSearchDTO bookSearchDTOStete = new BookSearchDTO();
		bookSearchDTOStete.setTitleS("");
		bookSearchDTOStete.setIsbnS("");
		bookSearchDTOStete.setAuthorS("");
		bookSearchDTOStete.setCategoryS("");
		bookSearchDTOStete.setPublisherS("");
		model.addAttribute("bookSearchDTO", bookSearchDTOStete);

		return "home";
	}

	@PostMapping("/")
	public String bookController(Model model, BookSearchDTO bookSearchDTO) {
		List<BookDTO> books = bookService.getAllBooks(bookSearchDTO);
		model.addAttribute("books", books);

		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);

		List<Publisher> publishers = publisherService.getAllPublishers();
		model.addAttribute("publishers", publishers);

		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);

		model.addAttribute("bookSearchDTO", bookSearchDTO);

		return "home";
	}

	@PostMapping("/add-book")
	public String addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return "redirect:/"; // Redirect to a page showing all books
	}

	@PostMapping("/delete-book")
	public String deleteBook(@RequestBody DeletingBookDTO deletingBookDTO) {
		bookService.deleteBook(List.of(deletingBookDTO.getIds()));
		return "redirect:/"; // Redirect to a page showing all books
	}

	@PostMapping("/modify_book")
	@ResponseBody
	public BookDTO modifyBook(@RequestBody BookSearchDTO bookSearchDTO) throws JsonProcessingException {
		List<BookDTO> book = bookService.getAllBooks(bookSearchDTO);
		return book.get(0);
	}
	
	@PostMapping("/update-book")
	public String updateBook(@RequestBody Book book) {
		bookService.addBook(book);
		return "redirect:/"; // Redirect to a page showing all books
	}
}
