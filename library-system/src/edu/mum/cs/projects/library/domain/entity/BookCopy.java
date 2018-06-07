package edu.mum.cs.projects.library.domain.entity;

public class BookCopy {
	private Book book;
	private String code;
	public BookCopy(Book book, String code) {
		super();
		this.book = book;
		this.code = code;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
