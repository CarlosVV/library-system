package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.dataaccess.BookDataAccessImpl;
import edu.mum.cs.projects.library.dataaccess.BookDataService;
import edu.mum.cs.projects.library.domain.entity.Book;

public class ServiceFactory {
	private volatile static CheckoutService checkoutService;
	private volatile static CheckoutDataService checkoutDataService;
	private volatile static BookService<Book> bookService;
	private volatile static BookDataService<Book> bookDataService;

	public static CheckoutService getCheckoutService() {
		if (null == checkoutService) {
			synchronized (ServiceFactory.class) {
				if (null == checkoutService) {
					checkoutService = new CheckoutServiceImpl(getCheckoutDataAccessService());
				}
			}
		}
		return checkoutService;
	}

	public static CheckoutDataService getCheckoutDataAccessService() {
		if (null == checkoutDataService) {
			synchronized (ServiceFactory.class) {
				if (null == checkoutDataService) {
					checkoutDataService = new CheckoutDataServiceImpl();
				}
			}
		}
		return checkoutDataService;
	}

	public static BookService<Book> getBookService() {
		if (null == bookService) {
			synchronized (ServiceFactory.class) {
				if (null == bookService) {
					bookService = new BookServiceImpl(getBookDataAccessService());
				}
			}
		}
		return bookService;
	}

	public static BookDataService<Book> getBookDataAccessService() {
		if (null == bookDataService) {
			synchronized (ServiceFactory.class) {
				if (null == bookDataService) {
					bookDataService = new BookDataAccessImpl();
				}
			}
		}
		return bookDataService;
	}
}
