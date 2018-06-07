package edu.mum.cs.projects.library.domain.service;


import java.util.List;

import edu.mum.cs.projects.library.dataaccess.UserDataAccess;
import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;

public class UserServiceImpl implements UserService {

	UserDataAccess userDataAccess = new UserDataAccess();
	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		
		return userDataAccess.checkUserIDandPassword(user);
		
	}
	@Override
	public List<LibraryRole> GetRoleList(User user) {
		// TODO Auto-generated method stub
		return userDataAccess.GetRoleList(user);
	}

}
