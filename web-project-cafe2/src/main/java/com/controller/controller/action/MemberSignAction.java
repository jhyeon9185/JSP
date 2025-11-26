package com.controller.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.MemberDAO;
import com.controller.dto.MemberVO;

public class MemberSignAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = request.getContextPath() + "/member/memberLogin.jsp";
		
		String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int admin = Integer.parseInt(request.getParameter("admin"));
		
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAdmin(admin);
		
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.insertMember(vo);
		
		response.sendRedirect(url);

	}

}
