package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.member.MemberLoginAction;

public class MemberFactory {
	
	private static MemberFactory instance = new MemberFactory();
	
	private MemberFactory() {}
	
	public static MemberFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		System.out.println("MemberFactory" + command);
		
		if(command.equals("member_login")) {
			action = new MemberLoginAction();
		}
		
		return action;
	}
	
}
