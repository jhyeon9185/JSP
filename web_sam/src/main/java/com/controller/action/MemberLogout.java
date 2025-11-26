package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogout implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//session.invalidate();
		//String message = "로그아웃 완";
		
		//request.setAttribute("message", "로그아웃 완");
		//request.getRequestDispatcher("/member/memberMain.jsp")
			//.forward(request, response);
		
		HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath() + "/index.jsp?msg=logout");
    }
		

	

}
