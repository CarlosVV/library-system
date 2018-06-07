package edu.mum.cs.projects.library.dataaccess;

import java.util.List;

import edu.mum.cs.projects.library.DataRecords;
import edu.mum.cs.projects.library.domain.entity.Book;

public class BookDataAccessImpl implements BookDataService<Book> {

	@Override
	public Book searchBookByISBN(String isbn) {
		List<Book> books = DataRecords.getBooks();
		Book returnBook = null;
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				returnBook = book;
				break;
			}
		}
		return returnBook;
	}

	@Override
	public boolean addBookToCollection(Book book) {
		List<Book> books = DataRecords.getBooks();
		boolean isBookAdded = false;
		for(Book bk : books) {
			if(bk.getIsbn().equals(book.getIsbn())) {
				DataRecords.getBooks().remove(bk);
				DataRecords.getBooks().add(bk);
				isBookAdded = true;
			}
		}
		return isBookAdded;
	}

}
