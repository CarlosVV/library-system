package edu.mum.cs.projects.library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.DataRecords;
import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;

public class UserDataAccessImpl implements UserDataAccess {
	List<User> userList = DataRecords.getAllMember();
	@Override
	public boolean checkUserIDandPassword(User user) {
		// TODO Auto-generated method stub
		
		for(User u: userList) {
			if (u.getUser().equals(user.getUser()) && u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<LibraryRole> GetRoleList(User user) {
		
		for(User u: userList) {
			if (u.getUser().equals(user.getUser())) {
				return u.getLibraryRoles();
			}
		}
		return null;
	}
}
