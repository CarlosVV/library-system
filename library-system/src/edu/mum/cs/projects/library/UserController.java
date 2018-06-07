package edu.mum.cs.projects.library;

import java.util.List;

import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.UserService;

public class UserController {
	private UserService service;	

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	public boolean validateUser(String userID,String Password) {
		User user = new User(userID,Password);
		return service.validateUser(user);
	}
	
	public List<LibraryRole> roles(String userID){
		User user = new User(userID);
		return service.GetRoleList(user);
	}
	
}
