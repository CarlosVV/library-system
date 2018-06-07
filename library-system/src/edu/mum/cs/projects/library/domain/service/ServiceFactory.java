package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.User;

public class ServiceFactory {
	private volatile static CheckoutService checkoutService;
	private volatile static CheckoutDataService checkoutDataService;
	private volatile static UserService userService;
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
	
}
