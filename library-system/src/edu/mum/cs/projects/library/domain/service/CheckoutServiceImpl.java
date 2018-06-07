package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;

public class CheckoutServiceImpl implements CheckoutService {
	private CheckoutDataService checkoutDataService;
	CheckoutServiceImpl(CheckoutDataService checkoutDataService) {
		this.checkoutDataService = checkoutDataService;
	}
	@Override
	public void checkoutBook(User member, BookCopy bookCopy) {
//		checkoutDataService.checkoutBookCopy(member, bookCopy);		
	}

}
