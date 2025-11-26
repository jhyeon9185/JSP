package com.controller.controller.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.ProductDAO;
import com.controller.dto.ProductVO;

public class ProductListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProductVO> list = ProductDAO.getInstance().selectAllProducts();

        request.setAttribute("productList", list);

        request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
    }
}
