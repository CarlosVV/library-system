package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.Book;

public interface BookService<Book> {
	Book searchBookByISBN(String isbn);
	boolean addBookToCollection(Book book);
}
