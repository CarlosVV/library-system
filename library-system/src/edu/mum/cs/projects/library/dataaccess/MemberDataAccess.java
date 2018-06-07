package edu.mum.cs.projects.library.dataaccess;

import edu.mum.cs.projects.library.domain.entity.User;

public interface MemberDataAccess {

	void addMember(User user) ;
	
	boolean checkMemberExistence(User user);

}
