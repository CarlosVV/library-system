package edu.mum.cs.projects.library;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.projects.library.domain.entity.User;

public class DataRecords {

	private static List<User>users = new ArrayList<>();
	
	public static List<User>  getAllMember() {
		
		return users;
	}
	public static void addMember(User user) {
		
		users.add(user);
	}
	
}
