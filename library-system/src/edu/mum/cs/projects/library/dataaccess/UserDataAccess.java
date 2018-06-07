package edu.mum.cs.projects.library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;

public class UserDataAccess {

	
	public boolean checkUserIDandPassword(User user) {
		if (user.getUser().equals("Admin") && user.getPassword().equals("123456") ||
				user.getUser().equals("Librarian") && user.getPassword().equals("123456"))
			return true; 
		return false;
	}
	
	public List<LibraryRole> GetRoleList(User user){
//		List<LibraryRole> roles = new ArrayList<>();
//		if (user.getUser().equals("Admin")) {
//			LibraryRole role = new LibraryRole("admin","administrator");
//			roles.add(role);		
//		}
//		else if (user.getUser().equals("Librarian")) {
//			LibraryRole role = new LibraryRole("librarian","librarian");
//			roles.add(role);		
//		}
//		else if (user.getUser().equals("Master")) {
//			LibraryRole role1 = new LibraryRole("librarian","librarian");
//			LibraryRole role2 = new LibraryRole("admin","administrator");
//			roles.add(role1);	
//			roles.add(role2);	
//		}
//		return roles;
		return user.getLibraryRoles();
	}
}
