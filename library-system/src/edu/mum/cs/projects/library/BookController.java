package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.Book;
import edu.mum.cs.projects.library.domain.service.BookService;

public class BookController {
	private final BookService<Book> bookService;
	
	public BookController(BookService<Book> bookService) {
		this.bookService = bookService;
	}
	
	public boolean addBookToCollection(Book book) {
		boolean isAdded = bookService.addBookToCollection(book);
		return isAdded;
	}
	
	public Book searchBookByISBN(String isbn) {
		Book book = bookService.searchBookByISBN(isbn);
		return book;
	}
}
