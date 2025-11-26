<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.controller.dto.ProductVO"%>
<%@ page import="com.controller.dao.ProductDAO"%>
<% int num=Integer.parseInt(request.getParameter("num")); 
        		ProductVO
                product=ProductDAO.getInstance().selectOneByNum(num); %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cafe Menu - 메뉴 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping.css">
</head>

<body>

	<div class="container">
		<h1>메뉴 수정</h1>

		<form
			action="${pageContext.request.contextPath}/ProductServlet?command=product_update"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="<%=product.getNum()%>" />
			<table>
				<tr>
					<td>메뉴명</td>
					<td><input type="text" name="name"
						value="<%=product.getName()%>" required /></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="number" name="price"
						value="<%=product.getPrice()%>" required /></td>
				</tr>
				<tr>
					<td>설명</td>
					<td><textarea name="description" rows="4"><%=product.getDescription()%></textarea>
					</td>
				</tr>
				<tr>
					<td>현재 이미지</td>
					<td><input type="hidden" name="oldPictureurl"
						value="<%=product.getPictureurl()%>"> <% if(product.getPictureurl() !=null && !product.getPictureurl().isEmpty()) { %>
						<img
						src="${pageContext.request.contextPath}/upload/<%=product.getPictureurl()%>"
						width="150" alt="현재 이미지" /><br> <% } %> <small
						style="color: #666;">새 이미지를 선택하면 기존 이미지가 교체됩니다.</small></td>
				</tr>
				<tr>
					<td>새 이미지</td>
					<td><input type="file" name="pictureurl" accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center; padding-top: 30px;">
						<input type="submit" value="수정하기" class="btn" /> <input
						type="button" value="취소" onclick="history.back();"
						class="btn btn-secondary" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>

</html>