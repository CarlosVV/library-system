package edu.mum.cs.projects.library.dataaccess;

public interface BookDataService<Book> {
	Book searchBookByISBN(String isbn);
	boolean addBookToCollection(Book book);
}
