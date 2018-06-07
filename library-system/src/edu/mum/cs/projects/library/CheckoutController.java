package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;
import edu.mum.cs.projects.library.domain.service.CheckoutService;

public class CheckoutController {
	private CheckoutService checkoutService;
	CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	public void checkoutBook(User member, BookCopy  bookCopy) {
		checkoutService.checkoutBook(member, bookCopy);
	}
	
	public CheckAvailabilityResult checkoutAvailability(String memberId, String  isbn) {
		return checkoutService.checkoutAvailability(memberId, isbn);
	}
	
	public void markBookAsAnavailable(BookCopy  bookCopy) {
		checkoutService.markBookAsAnavailable(bookCopy);
	}

	public void updateCheckbookTable() {
		System.out.println("Updating table...");
	}
}
