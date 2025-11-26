package com.controller.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.MemberDAO;
import com.controller.dto.MemberVO;


public class MemberWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = request.getContextPath() + "/member/memberWrite.jsp";
		
		response.sendRedirect(url);
	}

}
