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
		return bookDataService.searchBookByISBN(isbn);
	}

	@Override
	public boolean addBookToCollection(Book book) { 
		return bookDataService.addBookToCollection(book);
	}

}
