/**
 * 
 */
package edu.mum.cs.projects.library;

//<<<<<<< HEAD
import edu.mum.cs.projects.library.domain.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//=======
import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.Author;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.BookService;
import edu.mum.cs.projects.library.domain.service.CheckoutService;
import edu.mum.cs.projects.library.domain.service.ServiceFactory;
//>>>>>>> 9658f57fd83568244ce771d86bd7a20675a64d4a

/**
 * @author carlos
 *
 */
public class Main {
	private static CheckoutController checkoutController;
	private static BookController bookController;
	/**
	 * @param args
	 */
	static {
		loadBooksToMemory();
	}

	public static void main(String[] args) {
		// begin of adding book to existing collection
		BookService<Book> bookService = ServiceFactory.getBookService();
		bookController = new BookController(bookService);

		Book book = bookController.searchBookByISBN("isbn1");
		if (book != null) {
			String str = "Book = " + book.getTitle() + " has " + book.getCopies() == null ? "0"
					: "" + book.getCopies().size() + " copies";
			System.out.println(str);
			BookCopy bookCopy = new BookCopy(book, "bookJay3");
			if (book.getCopies() != null) {
				book.getCopies().add(bookCopy);
				bookController.addBookToCollection(book);
				Book testBook = bookController.searchBookByISBN("isbn1");
				str = "Book = " + testBook.getTitle() + " has " + testBook.getCopies() == null ? "0"
						: "" + testBook.getCopies().size() + " copies";
				System.out.println(str);
			}
		}
		// end of adding book to existing collection
	}

	public static void testCheckoutbook() {
		CheckoutService checkoutService = ServiceFactory.getCheckoutService();
		checkoutController = new CheckoutController(checkoutService);
		Address address = new Address(null, null, null, null);
		User member = new User("Carlos ", "Valderrama", "", null, null, null);
		BookCopy bookCopy = null;
		checkoutController.CheckoutBook(member, bookCopy);
		// >>>>>>> 9658f57fd83568244ce771d86bd7a20675a64d4a
	}

	private static void loadBooksToMemory() {
		Address address = new Address("4th Street", "Faifield", "Iowa", "52557");
		Author author = new Author("Oluwajoba", "Adegboye", "+16415050726", address, "Credential",
				"Programming is sweet especially when you have everything figured");
		List<Author> authors1 = new ArrayList<>();
		authors1.add(author);
		Book book = new Book("isbn1", "Begin Java", false, 7, true, authors1, null);
		List<BookCopy> bookCopies1 = new ArrayList<>();
		bookCopies1.add(new BookCopy(book, "bookJay1"));
		bookCopies1.add(new BookCopy(book, "bookJay2"));
		book.setCopies(bookCopies1);

		List<Book> books = new ArrayList<>();
		books.add(book);

		DataRecords.setBooks(books);
	}

}
