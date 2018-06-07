package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;

public interface CheckoutDataService {
	void checkoutBookCopy(User member, BookCopy bookCopy);

	CheckAvailabilityResult checkoutAvailability(String memberId, String isbn);

	void markBookAsAnavailable(BookCopy bookCopy);
}
