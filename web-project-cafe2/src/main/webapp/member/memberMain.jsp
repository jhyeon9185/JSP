<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<c:if test="${empty loginUser }">
			<jsp:forward page="/MemberServlet?command=member_login" />
		</c:if>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
		</head>

		<body>
			<form action="${pageContext.request.contextPath}/MemberServlet">
				<header>
					<div class="nav-wrap">

						<h1 class="logo">
							<a href="${pageContext.request.contextPath}/MemberServlet?command=member_main">LOGO</a>
						</h1>

						<nav class="main-menu">
							<a href="${pageContext.request.contextPath}/ProductServlet?command=product_list">메뉴소개</a>
							<a href="${pageContext.request.contextPath}/BoardServlet?command=board_list">자유게시판</a>
						</nav>

						<div class="user-menu">
							<a href="${pageContext.request.contextPath}/MemberServlet?command=member_update_form"
								class="login">회원정보수정</a>
							<a href="${pageContext.request.contextPath}/MemberServlet?command=member_logout">로그아웃</a>
						</div>

					</div>
				</header>

				<section>
					<div class="slider">
						<img src="${pageContext.request.contextPath}/img/slider.jpg" alt="mainImg">
					</div>

				</section>

				<footer>
					<div class="inner">
						<p class="copy">COPYRIGHT ⓒ 2025 김백함정. ALL RIGHTS RESERVED.</p>
					</div>
				</footer>
			</form>

		</body>

		</html>