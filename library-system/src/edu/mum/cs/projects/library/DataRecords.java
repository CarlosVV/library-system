package edu.mum.cs.projects.library;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.Author;
import edu.mum.cs.projects.library.domain.entity.Book;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.Person;
import edu.mum.cs.projects.library.domain.entity.User;

public class DataRecords {

	private static List<User> users = new ArrayList<>();
	private static List<BookCopy> bookCopies = new ArrayList<>();

	public static List<User> getAllMember() {

		return users;
	}

	public static void addMember(User user) {

		users.add(user);
	}

	public static List<BookCopy> getAllBookCopies() {
		Address address = new Address("123 ABC N St", "Chicago", "IL", "11111");
		Author author = new Author("Jhon", "Doe", "555-555-5555", address, "credentials", "bio");
		Book book = new Book("123", "the sun", true, 7, true, new ArrayList<Author>(), new ArrayList<BookCopy>());
		book.getAuthors().add(author);
		BookCopy bookCopy = new BookCopy(book, "1");
		book.getCopies().add(bookCopy);
		bookCopies.add(bookCopy);
		return bookCopies;
	}

}
