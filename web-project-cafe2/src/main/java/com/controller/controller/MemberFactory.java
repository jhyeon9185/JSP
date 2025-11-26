package com.controller.controller;

import com.controller.controller.action.Action;
import com.controller.controller.action.MemberIdCheck;
import com.controller.controller.action.MemberLoginAction;
import com.controller.controller.action.MemberLogout;
import com.controller.controller.action.MemberMainAction;
import com.controller.controller.action.MemberSignAction;
import com.controller.controller.action.MemberUpdateAction;
import com.controller.controller.action.MemberUpdateFormAction;
import com.controller.controller.action.MemberWriteAction;

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
		
		}else if(command.equals("member_main")) {
			action = new MemberMainAction();
			
		}else if(command.equals("member_write")) {
			action = new MemberWriteAction();
			
		}else if(command.equals("member_id_check")) {
			action = new MemberIdCheck();
			
		}else if(command.equals("member_update")) {
		    action = new MemberUpdateAction();
		    
		}else if(command.equals("member_logout")) {
			action = new MemberLogout();
			
		}else if (command.equals("member_sign")) {
			action = new MemberSignAction();
			
		}else if (command.equals("member_update_form")) {
			action = new MemberUpdateFormAction();
		}
		
		
		
		return action;
	}
}
