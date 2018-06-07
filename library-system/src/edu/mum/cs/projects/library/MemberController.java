package edu.mum.cs.projects.library;

import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.service.MemberService;
import edu.mum.cs.projects.library.domain.service.ServiceFactory;

public class MemberController {
	MemberService memberService;

	public String addMember(User user) {

		memberService = ServiceFactory.getMemberService();

		return memberService.addMember(user);

	}
}
