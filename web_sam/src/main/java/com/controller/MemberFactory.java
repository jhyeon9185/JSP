package com.controller;

import com.controller.action.Action;
import com.controller.action.MemberIdCheck;
import com.controller.action.MemberLoginAction;
import com.controller.action.MemberLogout;
import com.controller.action.MemberUpdateAction;
import com.controller.action.MemberWriteAction;

public class MemberFactory {
	
	private static MemberFactory instance = new MemberFactory();
	
	private MemberFactory() {}
	
	public static MemberFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("MemberFactory : " + command);
		
		if(command.equals("member_login")) {
			action = new MemberLoginAction();
			
		}else if(command.equals("member_write")) {
			action = new MemberWriteAction();
			
		}else if(command.equals("member_id_check")) {
			action = new MemberIdCheck();
			
		}else if(command.equals("member_update")) {
		    action = new MemberUpdateAction();
		    
		}else if(command.equals("member_logout")) {
			action = new MemberLogout();
			
		}
		
		
		
		return action;
	}
}
