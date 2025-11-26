package com.controller.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.ProductDAO;

public class ProductDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        ProductDAO.getInstance().deleteProduct(num);
        response.sendRedirect(request.getContextPath() + "/ProductServlet?command=product_list");
    }
}
