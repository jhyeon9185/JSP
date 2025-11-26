package com.saeyan.controller.action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.dao.MemberDAO;
import com.saeyan.controller.dto.MemberVO;

public class MemberLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		boolean result = dao.getuserchek(userid, pwd);
		
		if(result == true) {
			
			MemberVO vo = dao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", vo);
			
			response.sendRedirect(request.getContextPath() + "/member/memberMain.jsp");
			return;
			
		}else {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			
			out.println("alert('아이디 또는 비밀번호 오류')");
			out.println("location.href='" + request.getContextPath() + "/member/memberLoginFoam.jsp';" );
			
			out.println("</script>");
			
			out.close();
			
			return;
		}
		
	}
	
}
