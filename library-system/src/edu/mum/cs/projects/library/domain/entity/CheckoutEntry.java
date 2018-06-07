package edu.mum.cs.projects.library.domain.entity;

import java.time.LocalDate;

public class CheckoutEntry {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	private CheckoutFine checkouFine;
	public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy, CheckoutFine checkouFine) {
		super();
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.bookCopy = bookCopy;
		this.checkouFine = checkouFine;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	public CheckoutFine getCheckouFine() {
		return checkouFine;
	}
	public void setCheckouFine(CheckoutFine checkouFine) {
		this.checkouFine = checkouFine;
	}	
	
	
}
