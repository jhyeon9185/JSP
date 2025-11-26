package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.MemberDAO;
import com.controller.dto.MemberVO;


public class MemberWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getContextPath() + "/member/memberWrite.jsp";
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO vo = new MemberVO();
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("password"));
		vo.setEmail(request.getParameter("email"));
		
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.updateMember(vo);
		
		response.sendRedirect(url);
	}

}
