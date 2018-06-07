package edu.mum.cs.projects.library.domain.entity;

import java.time.LocalDate;

public class CheckoutFine {
	private CheckoutEntry checkoutEntry;
	private LocalDate returnDate;
	private double amountPaid;
	public CheckoutFine(CheckoutEntry checkoutEntry, LocalDate returnDate, double amountPaid) {
		super();
		this.checkoutEntry = checkoutEntry;
		this.returnDate = returnDate;
		this.amountPaid = amountPaid;
	}
	public CheckoutEntry getCheckoutEntry() {
		return checkoutEntry;
	}
	public void setCheckoutEntry(CheckoutEntry checkoutEntry) {
		this.checkoutEntry = checkoutEntry;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
}
