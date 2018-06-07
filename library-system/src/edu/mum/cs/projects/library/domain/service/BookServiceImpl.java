package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.dataaccess.BookDataService;
import edu.mum.cs.projects.library.domain.entity.Book;

public class BookServiceImpl implements BookService<Book> {
	private BookDataService<Book> bookDataService;
	public BookServiceImpl(BookDataService<Book> bookDataService) {
		this.bookDataService = bookDataService;
	}
	@Override
	public Book searchBookByISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBookToCollection(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
