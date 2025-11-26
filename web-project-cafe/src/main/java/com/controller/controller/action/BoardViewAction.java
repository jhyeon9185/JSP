package com.controller.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.BoardDAO;
import com.controller.dto.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/board/boardView.jsp";
		
		//1. num 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		
		//2. DB에서 해당하는 num 값 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOneByNum(num);
		
		//3. 조회수 증가
		dao.updateReadCount(num);
		
		//4. boardView 값 전달하기
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(url)
		.forward(request, response);
		
	}

}
