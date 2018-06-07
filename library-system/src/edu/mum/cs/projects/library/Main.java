/**
 * 
 */
package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.Author;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.LibraryMember;
import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.BookService;
import edu.mum.cs.projects.library.domain.entity.Book;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;
import edu.mum.cs.projects.library.domain.service.CheckoutService;
import edu.mum.cs.projects.library.domain.service.ServiceFactory;
import edu.mum.cs.projects.library.domain.service.UserService;

/**
 * @author carlos
 *
 */
public class Main {
	private static CheckoutController checkoutController;
	private static BookController bookController;
	private static UserController userController;
	/**
	 * @param args
	 */
	static {
		loadBooksToMemory();
		loadUserToMemory();
	}

	public static void main(String[] args) {

		System.out.println("Library System");

		// 1. Login
		validateUser("master", "123456");

		//2: add member 
		addNewMember();

		
		// 3. Checkout Book
		testCheckoutbook();

		// 4: add existing book to collection
		addBookToCollection("isbn1");
	}

	public static void testCheckoutbook() {
		System.out.println("Creating Checkout Service");
		CheckoutService checkoutService = ServiceFactory.getCheckoutService();

		System.out.println("Creating Checkout Controller");
		checkoutController = new CheckoutController(checkoutService);

		Address address = new Address(null, null, null, null);
		User member = new User("Carlos ", "Valderrama", "", null, null, null);
		BookCopy bookCopy = new BookCopy(new Book("123", null, null, 0, null, null, null), "1");
		String memberId = "1";
		String isbn = "123";

		// checkoutAvailability
		CheckAvailabilityResult availability = checkoutController.checkoutAvailability(memberId, isbn);

		// checkoutBook Exists
		if (!availability.getBookExists()) {
			System.out.println("Book does not exist");
			return;
		} else // checkoutBook Not available
		if (!availability.getBookNotAvailable()) {
			System.out.println("Book not available");
			return;
		} else {
			// Checkout Book
			System.out.println("Calling Checkout Book");
			checkoutController.checkoutBook(member, bookCopy);
			// Mark Book Not available
			System.out.println("Mark Book Not available");
			checkoutController.markBookAsAnavailable(bookCopy);
		}

		checkoutController.updateCheckbookTable();
	}

	private static void loadUserToMemory() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		LibraryRole admin = new LibraryRole("admin", "admin");
		LibraryRole librarian = new LibraryRole("librarian", "librarian");

		List<LibraryRole> role1 = new ArrayList<>();
		role1.add(admin);
		List<LibraryRole> role2 = new ArrayList<>();
		role2.add(librarian);
		List<LibraryRole> role3 = new ArrayList<>();
		role3.add(admin);
		role3.add(librarian);

		userList.add(new User("admin", "123456", role1));
		userList.add(new User("librarian", "123456", role2));
		userList.add(new User("master", "123456", role3));

		DataRecords.setUsers(userList);

	}

	public static void validateUser(String userID, String Password) {

		System.out.println("Creating User Service");
		UserService userService = ServiceFactory.getUserService();

		System.out.println("Creating User Controller");
		userController = new UserController(userService);

		if (userController.validateUser(userID, Password)) {
			System.out.println("Login correctly");
			List<LibraryRole> roles = userController.roles(userID);
			if (roles == null) {
				System.out.println(userID + " no role");
			} else {
				System.out.print("User '" + userID + "' containts role:");
				for (LibraryRole r : roles) {
					System.out.print(r.getName() + " ");
				}
				System.out.println();
			}
		} else
			System.out.println("Invalid UserID or Password");
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
		BookService<Book> bookService = ServiceFactory.getBookService();
		bookController = new BookController(bookService);
		Book book = bookController.searchBookByISBN(isbn);
		System.out.println("Adding Book to collection");
		if (book != null) {
			String str = String.format("Book  %s  has %s copies before adding",book.getTitle(),book.getCopies().size());
			System.out.println(str);
			BookCopy bookCopy = new BookCopy(book, "bookJay3");
			if (book.getCopies() != null) {
				book.getCopies().add(bookCopy);
				bookController.addBookToCollection(book);
				Book testBook = bookController.searchBookByISBN("isbn1");
				str = String.format("Book %s  has %s copies after a adding",testBook.getTitle(),testBook.getCopies().size());
				System.out.println(str);
			}
		}
	}
	public static void addNewMember() {
		
		List<LibraryRole> libraryRoles = new ArrayList<>();
		Address  address = new Address("street1", "fairfied", "iowa", "12345");
		libraryRoles.add(new LibraryMember("Library Member", "can checkout books"));
		User user = new User("moustafa" , "sayed", "0112", address, "123", libraryRoles);
		
		MemberController controller = new MemberController();
		
		System.out.println(controller.addMember(user));
		System.out.println("User moustafa with code 123 has been added");
		System.out.println();
		
		User user1 = new User("moustafa" , "sayed", "0112", address, "123", libraryRoles);
		System.out.println(controller.addMember(user1));
		System.out.println("User moustafa with the same code 123 already exist in the system");
		System.out.println();

		User user2 = new User("ahmed" , "ali", "0113", address, "22", libraryRoles);
		System.out.println(controller.addMember(user2));
		System.out.println("User ahmed with code 22 has been added");
		System.out.println();
		
	}
}
