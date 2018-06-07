package edu.mum.cs.projects.library.domain.service;


import edu.mum.cs.projects.library.dataaccess.UserDataAccess;
import edu.mum.cs.projects.library.dataaccess.UserDataAccessImpl;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;

public class ServiceFactory {
	private volatile static CheckoutService checkoutService;
	private volatile static CheckoutDataService checkoutDataService;
	private volatile static UserService userService;
	private volatile static UserDataAccess userDataAccess;
	public static CheckoutService getCheckoutService() {
		if(null == checkoutService) {
			synchronized(ServiceFactory.class) {
				if(null == checkoutService) {
					checkoutService = new CheckoutServiceImpl(getCheckoutDataAccessService());
				}
			}
		}
		return checkoutService;
	}
	public static CheckoutDataService getCheckoutDataAccessService() {
		if(null == checkoutDataService) {
			synchronized(ServiceFactory.class) {
				if(null == checkoutDataService) {
					checkoutDataService = new CheckoutDataServiceImpl();
				}
			}
		}
		return checkoutDataService;
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
}
