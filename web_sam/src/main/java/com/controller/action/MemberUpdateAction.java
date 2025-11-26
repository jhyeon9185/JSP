package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.dao.MemberDAO;
import com.controller.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        MemberVO vo = (MemberVO)session.getAttribute("loginUser");

        vo.setName(name);
        vo.setEmail(email);

        MemberDAO dao = MemberDAO.getInstance();
        dao.updateMember(vo);

        session.setAttribute("loginUser", vo); // 세션 갱신

        response.sendRedirect(request.getContextPath() + "/member/memberUpdate.jsp");
    }
}


