<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Insert title here</title>

                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopping_list.css">

            </head>

            <body>
                <div id="wrap" align="center">
                    <h1 class="title">자유 게시판</h1>
                    <div class="wrap-display">
                        <table class="board-table">
                            <tr>
                                <td colspan="5" style="border: none; text-align: right; padding: 10px 20px;">
                                    <a href="${pageContext.request.contextPath}/BoardServlet?command=board_write_form"
                                        class="btn-write">게시글 등록</a>
                                </td>
                            </tr>

                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회</th>
                            </tr>

                            <c:forEach var="board" items="${boardList}">
                                <tr>
                                    <td class="num">${board.num}</td>
                                    <td class="title"><a href="${pageContext.request.contextPath}/BoardServlet?command=board_view&num=${board.num}">${board.title}</a>
                                    </td>
                                    <td class="writer">${board.name}</td>
                                    <td class="date">
                                        <fmt:formatDate value="${board.writedate}" pattern="yyyy-MM-dd" />
                                    </td>
                                    <td class="count">${board.readcount}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </body>

            </html>