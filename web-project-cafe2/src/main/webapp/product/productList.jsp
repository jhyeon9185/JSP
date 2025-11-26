<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cafe Menu - 상품 목록</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping.css">

</head>

<body>

	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/member/memberMain.jsp">Cafe
				Menu</a>
		</h1>

		<div class="top-actions">
			<a href="${pageContext.request.contextPath}/product/productWrite.jsp"
				class="btn">신규 메뉴 등록</a>
		</div>

		<div class="menu-grid">
			<c:forEach var="product" items="${productList}">
				<a
					href="${pageContext.request.contextPath}/ProductServlet?command=product_detail&num=${product.num}"
					class="menu-card">

					<div class="card-image">
						<c:if test="${not empty product.pictureurl}">
							<img
								src="${pageContext.request.contextPath}/upload/${product.pictureurl}"
								alt="${product.name}" />
						</c:if>
						<c:if test="${empty product.pictureurl}">
							<div class="no-image">이미지 없음</div>
						</c:if>
					</div>
					<div class="card-name">${product.name}</div>
				</a>
			</c:forEach>
		</div>
	</div>

</body>

</html>