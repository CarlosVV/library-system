package edu.mum.cs.projects.library.domain.entity;

import java.util.List;

public class User  extends Person {
	
	public User(String username, String password) {
		super();
		this.user = username;
		this.password = password;
	}
	public User(String username) {
		super();
		this.user = username;
	}
	public User(String username, String password, List<LibraryRole> libraryRoles) {
		super();
		this.user = username;
		this.password = password;
		this.libraryRoles = libraryRoles;
	}
	public User(String firstName, String lastName, String phoneNumber, Address address, String code, List<LibraryRole> libraryRoles) {
		super(firstName, lastName, phoneNumber, address);
		this.setCode(code);
		this.setLibraryRoles(libraryRoles);
	}
	

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libraryRoles
	 */
	public List<LibraryRole> getLibraryRoles() {
		return libraryRoles;
	}

	/**
	 * @param libraryRoles the libraryRoles to set
	 */
	public void setLibraryRoles(List<LibraryRole> libraryRoles) {
		this.libraryRoles = libraryRoles;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

	private String code;
	private List<LibraryRole> libraryRoles;
	private String user;
	private String password;
}
