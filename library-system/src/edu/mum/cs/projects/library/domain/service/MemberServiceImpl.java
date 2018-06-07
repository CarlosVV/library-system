package edu.mum.cs.projects.library.domain.service;

import edu.mum.cs.projects.library.dataaccess.MemberDataAccess;
import edu.mum.cs.projects.library.domain.entity.User;

public class MemberServiceImpl implements MemberService {

	private MemberDataAccess memberDataAccess;
	MemberServiceImpl(MemberDataAccess memberDataAccess) {
		this.memberDataAccess = memberDataAccess;
	}
	@Override
	public String addMember(User user) {

		if(checkMemberExistence(user))
			return "User already exist";
		else
			this.memberDataAccess.addMember(user);
			

		return "Member has been added";
	}
	@Override
	public boolean checkMemberExistence(User user) {
		if(this.memberDataAccess.checkMemberExistence(user))
			return true;
		
			return false;
	}

	
	
}
