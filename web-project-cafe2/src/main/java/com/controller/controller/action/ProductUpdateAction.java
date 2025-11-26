package com.controller.controller.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.ProductDAO;
import com.controller.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductUpdateAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String savePath = request.getServletContext().getRealPath("upload");

        // 디렉토리 생성 로직 추가
        File uploadDir = new File(savePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        int sizeLimit = 5 * 1024 * 1024;
        String encType = "UTF-8";

        System.out.println("ProductUpdateAction: savePath = " + savePath);

        try {
            MultipartRequest multi = new MultipartRequest(
                    request,
                    savePath,
                    sizeLimit,
                    encType,
                    new DefaultFileRenamePolicy());

            ProductVO vo = new ProductVO();
            String numStr = multi.getParameter("num");
            if (numStr == null || numStr.isEmpty()) {
                throw new IllegalArgumentException("상품 번호(num)가 전달되지 않았습니다.");
            }

            vo.setNum(Integer.parseInt(numStr));
            vo.setName(multi.getParameter("name"));

            String priceStr = multi.getParameter("price");
            if (priceStr != null && !priceStr.isEmpty()) {
                vo.setPrice(Integer.parseInt(priceStr));
            }

            vo.setDescription(multi.getParameter("description"));

            String pictureurl = multi.getFilesystemName("pictureurl");
            if (pictureurl == null) {
                pictureurl = multi.getParameter("oldPictureurl");
            }
            vo.setPictureurl(pictureurl);

            ProductDAO.getInstance().updateProduct(vo);

            response.sendRedirect(request.getContextPath() + "/ProductServlet?command=product_list");

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("ProductUpdateAction error: " + e.getMessage());

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>상품 수정 중 오류가 발생했습니다.</h1>");
            response.getWriter().println("<p>Error Type: " + e.getClass().getName() + "</p>");
            response.getWriter().println("<p>Error Message: " + e.getMessage() + "</p>");
            response.getWriter().println("<p>Save Path: " + savePath + "</p>");
            response.getWriter().println("<button onclick='history.back()'>뒤로가기</button>");
            response.getWriter().println("</body></html>");
        }
    }
}
