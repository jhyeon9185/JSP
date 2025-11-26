<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.controller.dto.ProductVO"%>
<% ProductVO product=(ProductVO) request.getAttribute("product"); %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cafe Menu - 상세보기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping.css">
</head>

<body>

	<div class="detail-container">
		<div class="detail-content">
			<div class="detail-number">
				No.
				<%=product.getNum()%>
			</div>

			<h1 class="detail-title">
				<%=product.getName()%>
			</h1>

			<div class="detail-image">
				<% if(product.getPictureurl() !=null && !product.getPictureurl().isEmpty()) { %>
				<img
					src="${pageContext.request.contextPath}/upload/<%=product.getPictureurl()%>"
					alt="<%=product.getName()%>" />
				<% } else { %>
				<div class="no-image">이미지 없음</div>
				<% } %>
			</div>

			<div class="detail-price">
				<%=product.getPrice()%>원
			</div>

			<div class="detail-description">
				<div class="description-label">설명</div>
				<div class="description-text">
					<%=product.getDescription()%>
				</div>
			</div>
		</div>

		<div class="detail-actions">
			<a
				href="${pageContext.request.contextPath}/ProductServlet?command=product_none_list"
				class="btn btn-secondary">목록으로</a>
		</div>
	</div>

</body>

</html>