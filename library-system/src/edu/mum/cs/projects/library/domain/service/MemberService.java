package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.domain.entity.User;

public interface MemberService {

	String addMember(User user);
	
	boolean checkMemberExistence(User user);
}
