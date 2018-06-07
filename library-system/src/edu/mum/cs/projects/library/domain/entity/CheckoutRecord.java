package edu.mum.cs.projects.library.domain.entity;

import java.time.LocalDate;
import java.util.List;

public class CheckoutRecord {
	private String recordId;
	private LocalDate date;
	private List<CheckoutEntry> checkoutEntries;
	private User user;
	private User authorizer;
	public CheckoutRecord(String recordId, LocalDate date, List<CheckoutEntry> checkoutEntries, User user,
			User authorizer) {
		super();
		this.recordId = recordId;
		this.date = date;
		this.checkoutEntries = checkoutEntries;
		this.user = user;
		this.authorizer = authorizer;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<CheckoutEntry> getCheckoutEntries() {
		return checkoutEntries;
	}
	public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
		this.checkoutEntries = checkoutEntries;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getAuthorizer() {
		return authorizer;
	}
	public void setAuthorizer(User authorizer) {
		this.authorizer = authorizer;
	}
	
	
}
