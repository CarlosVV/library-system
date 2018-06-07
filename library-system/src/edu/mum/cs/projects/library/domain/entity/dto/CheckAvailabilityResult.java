package edu.mum.cs.projects.library.domain.entity.dto;

public class CheckAvailabilityResult {
	private Boolean bookExists;
	private Boolean bookNotAvailable;
	public CheckAvailabilityResult(Boolean bookExists, Boolean bookNotAvailable) {
		super();
		this.bookExists = bookExists;
		this.bookNotAvailable = bookNotAvailable;
	}
	public Boolean getBookExists() {
		return bookExists;
	}
	public void setBookExists(Boolean bookExists) {
		this.bookExists = bookExists;
	}
	public Boolean getBookNotAvailable() {
		return bookNotAvailable;
	}
	public void setBookNotAvailable(Boolean bookNotAvailable) {
		this.bookNotAvailable = bookNotAvailable;
	}
	
	
}
