package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;

public interface CheckoutService {

	void checkoutBook(User member, BookCopy bookCopy);

}
