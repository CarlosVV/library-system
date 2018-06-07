package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.CheckoutService;

public class CheckoutController {
	private CheckoutService checkoutService;
	CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	public void CheckoutBook(User member, BookCopy  bookCopy) {
		checkoutService.checkoutBook(member, bookCopy);
	}
}
