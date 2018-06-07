/**
 * 
 */
package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.Book;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;
import edu.mum.cs.projects.library.domain.service.CheckoutService;
import edu.mum.cs.projects.library.domain.service.ServiceFactory;

/**
 * @author carlos
 *
 */
public class Main {
	private static CheckoutController checkoutController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Library System");

		// 1. Login

		// 2. Checkout Book
		testCheckoutbook();
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
