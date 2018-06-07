package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;

public class CheckoutServiceImpl implements CheckoutService {
	private CheckoutDataService checkoutDataService;

	CheckoutServiceImpl(CheckoutDataService checkoutDataService) {
		this.checkoutDataService = checkoutDataService;
	}

	@Override
	public void checkoutBook(User member, BookCopy bookCopy) {  
		checkoutDataService.checkoutBookCopy(member, bookCopy);
	}

	@Override
	public CheckAvailabilityResult checkoutAvailability(String memberId, String isbn) {
		return checkoutDataService.checkoutAvailability(memberId, isbn);

	}

	@Override
	public void markBookAsAnavailable(BookCopy bookCopy) {
		checkoutDataService.markBookAsAnavailable(bookCopy); 
	}

}
