package com.controller.action;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.dao.MemberDAO;
import com.controller.dto.MemberVO;



public class MemberLoginAction implements Action {
	

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		
		String url = "/member/memberLogin.jsp";
		
		MemberDAO dao = MemberDAO.getInstance();		
		boolean result = dao.userCheck(userid, password);
		
		if(result == true) {
		    MemberVO vo = dao.getMember(userid);
		    HttpSession session = request.getSession();
		    session.setAttribute("loginUser", vo);

		    url = "/member/memberMain.jsp";

		} else {

		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = response.getWriter();

		    out.println("<script>");
		    out.println("alert('아이디 또는 비밀번호가 틀렸습니다.');");
		    out.println("location.href='" + request.getContextPath() + "/member/memberLogin.jsp';");
		    out.println("</script>");
		    out.close();

		    return;   // ★ forward 하지 않도록 return 필요
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}	
}
