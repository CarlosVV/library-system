package edu.mum.cs.projects.library.domain.entity;

public class Author extends Person {
	public Author(String firstName, String lastName, String phoneNumber, Address address, 
			String credentials, String bio) {
		super(firstName, lastName, phoneNumber, address);
		this.credentials = credentials;
		this.bio = bio;		
	}
	
	private String credentials;
	private String bio;
	
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
