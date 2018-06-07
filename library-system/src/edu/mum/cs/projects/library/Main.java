/**
 * 
 */
package edu.mum.cs.projects.library;


import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.Address;
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
	private static UserController userController;
	/**
	 * @param args
	 */
	static {
		loadUserToMemory();
	}
	public static void main(String[] args) {
		System.out.println("Library System");

		// 1. Login
		validateUser("master","123456");

		// 3. Checkout Book
		testCheckoutbook();
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

}
