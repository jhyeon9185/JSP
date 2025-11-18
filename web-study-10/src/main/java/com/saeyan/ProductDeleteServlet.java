package com.saeyan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductDeleteServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. code(default) 획득
		String code = request.getParameter("code");
		
		// 2. DB > code 해당 값 삭제
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO vo = pdao.selectProductByCode(code);
		
		
		// 3. request.setAttribute
		request.setAttribute("product", vo);
		
		// 4. forword
		request.getRequestDispatcher("product/productDelete.jsp")
			.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. code 값 획득
		int code = Integer.parseInt(request.getParameter("code"));
		
		// 2. DB > code 값 삭제
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.deleteProduct(code);
		
		//3. redirct > productList.do
		response.sendRedirect("productList.do");
		
	}

}
