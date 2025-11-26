package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        String command = request.getParameter("command");
        System.out.println("ProductServlet : command 요청 받음 -> " + command);

        ProductFactory af = ProductFactory.getInstance();
        
        Action action = af.getAction(command);

        if (action != null) {
            System.out.println("Action 실행 : " + action.getClass().getName());
            action.execute(request, response);
            
        } else {
            System.out.println("Action이 null입니다. command: " + command);
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>잘못된 요청입니다.</h1>");
            response.getWriter().println("<p>Command: " + command + "</p>");
            response.getWriter().println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}