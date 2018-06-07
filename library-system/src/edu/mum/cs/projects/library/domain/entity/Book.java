package edu.mum.cs.projects.library.domain.entity;

import java.util.List;

public class Book {
	private String isbn;
	private String title;
	private Boolean availability;
	private int allowedBorrowedDays;
	private Boolean isPopular;
	private List<Author> authors;
	private List<BookCopy> copies;
	public Book(String isbn, String title, Boolean availability, int allowedBorrowedDays, Boolean isPopular,
			List<Author> authors, List<BookCopy> copies) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.availability = availability;
		this.allowedBorrowedDays = allowedBorrowedDays;
		this.isPopular = isPopular;
		this.authors = authors;
		this.copies = copies;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	public int getAllowedBorrowedDays() {
		return allowedBorrowedDays;
	}
	public void setAllowedBorrowedDays(int allowedBorrowedDays) {
		this.allowedBorrowedDays = allowedBorrowedDays;
	}
	public Boolean getIsPopular() {
		return isPopular;
	}
	public void setIsPopular(Boolean isPopular) {
		this.isPopular = isPopular;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}
	
	
}
