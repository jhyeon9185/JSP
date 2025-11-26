package com.controller.controller.action;

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
		
		String url = request.getContextPath() + "/member/memberMain.jsp";

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String userid = request.getParameter("userid");

        MemberVO vo = new MemberVO();

        if (name != null) vo.setName(name);
        if (email != null) vo.setEmail(email);
        if (password != null) vo.setPwd(password);
        if (phone != null) vo.setPhone(phone);
        if (userid != null) vo.setUserid(userid);
        
        MemberDAO dao = MemberDAO.getInstance();
        dao.updateMember(vo);
		
		response.sendRedirect(url);
    }
}


