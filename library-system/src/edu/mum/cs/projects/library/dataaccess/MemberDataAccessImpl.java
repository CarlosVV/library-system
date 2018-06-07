package edu.mum.cs.projects.library.dataaccess;

import edu.mum.cs.projects.library.DataRecords;
import edu.mum.cs.projects.library.domain.entity.User;

public class MemberDataAccessImpl implements MemberDataAccess {

	@Override
	public void addMember(User user) {

		DataRecords.addMember(user);
	}

	@Override
	public boolean checkMemberExistence(User user) {
		
		for(User userItem : DataRecords.getAllMember()) {
			
			if( userItem.getCode() != null && userItem.getCode().equals(user.getCode()))
				return true;
		}
		return false;
	}
	
	
	

}
