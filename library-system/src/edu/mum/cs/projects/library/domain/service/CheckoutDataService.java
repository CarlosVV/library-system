package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;

public interface CheckoutDataService {
	void checkoutBookCopy(User member, BookCopy bookCopy);
}
