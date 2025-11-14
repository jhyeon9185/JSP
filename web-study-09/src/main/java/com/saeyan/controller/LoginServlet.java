package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		//dis.forward(request, response);
		
		// 더 간단하게
		request.getRequestDispatcher("member/login.jsp")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String url = "member/login.jsp";
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		boolean result = mdao.userCheck(userid, pwd);
		
		if(result == true) {
			MemberVO mvo = mdao.getMember(userid);
			
			// 로그인 성공한 유저정보를 session 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			request.setAttribute("message", "로그인 성공했습니다.");
			url = "member/main.jsp";
			
		}else{
			request.setAttribute("message", "로그인 실패했습니다.");
			
		}// end if
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
