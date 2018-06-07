package edu.mum.cs.projects.library.domain.service;

import java.util.List;

import edu.mum.cs.projects.library.domain.entity.LibraryRole;
import edu.mum.cs.projects.library.domain.entity.User;

public interface UserService {
	boolean validateUser(User user);
	List<LibraryRole> GetRoleList(User user);
}
