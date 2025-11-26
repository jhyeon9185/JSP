package com.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.ProductDAO;
import com.controller.dto.ProductVO;

public class ProductDetailAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        ProductVO product = ProductDAO.getInstance().selectOneByNum(num);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/productDetail.jsp").forward(request, response);
    }
}
