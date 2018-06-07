/**
 * 
 */
package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.Address;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
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
	}
	
	public static void testCheckoutbook() {
		CheckoutService checkoutService = ServiceFactory.getCheckoutService();
		checkoutController = new CheckoutController(checkoutService);
		Address address = new Address(null, null, null, null);
		User member = new User("Carlos ", "Valderrama", "", null, null, null);
		BookCopy bookCopy = null;
		checkoutController.CheckoutBook(member, bookCopy);
	}

}
