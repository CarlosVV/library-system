/**
 * 
 */
package edu.mum.cs.projects.library;

<<<<<<< HEAD
//<<<<<<< HEAD
import edu.mum.cs.projects.library.domain.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//=======
=======

import java.util.ArrayList;
import java.util.List;

>>>>>>> c4b5a9c42c22fb60e1b4e40f80bca78500156421
import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.Author;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.BookService;
import edu.mum.cs.projects.library.domain.service.CheckoutService;
import edu.mum.cs.projects.library.domain.service.ServiceFactory;
<<<<<<< HEAD
//>>>>>>> 9658f57fd83568244ce771d86bd7a20675a64d4a
=======
import edu.mum.cs.projects.library.domain.service.UserService;
>>>>>>> c4b5a9c42c22fb60e1b4e40f80bca78500156421

/**
 * @author carlos
 *
 */
public class Main {
	private static CheckoutController checkoutController;
<<<<<<< HEAD
	private static BookController bookController;
=======
	private static UserController userController;
>>>>>>> c4b5a9c42c22fb60e1b4e40f80bca78500156421
	/**
	 * @param args
	 */
	static {
<<<<<<< HEAD
		loadBooksToMemory();
	}

=======
		loadUserToMemory();
	}
>>>>>>> c4b5a9c42c22fb60e1b4e40f80bca78500156421
	public static void main(String[] args) {
		// begin of adding book to existing collection
		BookService<Book> bookService = ServiceFactory.getBookService();
		bookController = new BookController(bookService);

<<<<<<< HEAD
		
		// end of adding book to existing collection
	}

=======
		System.out.println("Library System");
		
		// 1. Login
		validateUser("master","123456");
		// 2. Checkout Book
		testCheckoutbook();
		
		//4: add existing book to collection
		addBookToCollection("isbn1");
	}
	private static void loadUserToMemory() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		LibraryRole admin = new LibraryRole("admin","admin");
		LibraryRole librarian = new LibraryRole("librarian","librarian");
		
		List<LibraryRole> role1 = new ArrayList<>();
		role1.add(admin);
		List<LibraryRole> role2 = new ArrayList<>();
		role2.add(librarian);
		List<LibraryRole> role3 = new ArrayList<>();
		role3.add(admin);
		role3.add(librarian);
		
		userList.add(new User("admin","123456",role1));
		userList.add(new User("librarian","123456",role2));
		userList.add(new User("master","123456",role3));
		
	     DataRecords.setUsers(userList);
		
	}
	public static void validateUser(String userID, String Password) {
		
		System.out.println("Creating User Service");
		UserService userService = ServiceFactory.getUserService();
		
		System.out.println("Creating User Controller");
		userController = new UserController(userService);
		
		if (userController.validateUser(userID, Password))
			{
				System.out.println("Login correctly");
				List<LibraryRole> roles = userController.roles(userID);
				if (roles == null) {
					System.out.println(userID + " no role");
				}
				else {
					System.out.print("User '"+ userID +"' containts role:");
					for(LibraryRole r: roles) {
						System.out.print(r.getName() + " ");
					}
					System.out.println();
				}
			}
		else
			System.out.println("Invalid UserID or Password");
	}
>>>>>>> c4b5a9c42c22fb60e1b4e40f80bca78500156421
	public static void testCheckoutbook() {
		System.out.println("Creating Checkout Service");
		CheckoutService checkoutService = ServiceFactory.getCheckoutService();
		
		System.out.println("Creating Checkout Controller");
		checkoutController = new CheckoutController(checkoutService);
		Address address = new Address(null, null, null, null);
		User member = new User("Carlos ", "Valderrama", "", null, null, null);
		BookCopy bookCopy = null;
		
		System.out.println("Calling Checkout Book");
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

	private static void addBookToCollection(String isbn) {
		Book book = bookController.searchBookByISBN(isbn);
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
	}
		
}
