package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.MemberDAO;

public class MemberIdCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.confirmID(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/member/memberIdCheck.jsp")
			.forward(request, response);
		
	}

}
