package edu.mum.cs.projects.library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;

public interface UserDataAccess {
	
	boolean checkUserIDandPassword(User user);
	List<LibraryRole> GetRoleList(User user);
}
