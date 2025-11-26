package com.controller.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.dto.MemberVO;

public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getContextPath() + "/member/memberUpdate.jsp";

		HttpSession session = request.getSession();
        MemberVO vo = (MemberVO)session.getAttribute("loginUser");
        session.setAttribute("loginUser", vo);
		
		response.sendRedirect(url);
	}

}
