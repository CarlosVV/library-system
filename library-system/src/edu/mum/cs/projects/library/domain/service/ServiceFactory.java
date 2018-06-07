package edu.mum.cs.projects.library.domain.service;
 
import edu.mum.cs.projects.library.dataaccess.BookDataAccessImpl;
import edu.mum.cs.projects.library.dataaccess.BookDataService;
import edu.mum.cs.projects.library.dataaccess.MemberDataAccess;
import edu.mum.cs.projects.library.dataaccess.MemberDataAccessImpl;
import edu.mum.cs.projects.library.domain.entity.Book; 
import edu.mum.cs.projects.library.dataaccess.UserDataAccess;
import edu.mum.cs.projects.library.dataaccess.UserDataAccessImpl;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User; 

public class ServiceFactory {
	private volatile static CheckoutService checkoutService;
	private volatile static CheckoutDataService checkoutDataService; 
	private volatile static BookService<Book> bookService;
	private volatile static BookDataService<Book> bookDataService; 
	private volatile static UserService userService;
	private volatile static UserDataAccess userDataAccess; 
	private volatile static MemberService memberService;
	private volatile static MemberDataAccess memberDataAccess;
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
	
	public static UserService getUserService() {
		if(null == userService) {
			synchronized(ServiceFactory.class) {
				if(null == userService) {
					userService = new UserServiceImpl();
				}
			}
		}
		return userService;
	}
	public static UserDataAccess getUserDataAccessService() {

		if(null == userDataAccess) {
			synchronized(ServiceFactory.class) {
				if(null == userDataAccess) {
					userDataAccess = new UserDataAccessImpl();
				}
			}
		}
		return userDataAccess; 
	}
	
	public static MemberService getMemberService() {
		if(null == memberService) {
			synchronized(ServiceFactory.class) {
				if(null == memberService) {
					memberService = new MemberServiceImpl(getMemberDataAccess());
				}
			}
		}
		return memberService;
	}
	
	public static MemberDataAccess getMemberDataAccess() {
		if(null == memberDataAccess) {
			synchronized(ServiceFactory.class) {
				if(null == memberDataAccess) {
					memberDataAccess = new MemberDataAccessImpl();
				}
			}
		}
		return memberDataAccess;
	}
}
