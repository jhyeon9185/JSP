<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
		<c:if test="${param.msg == 'logout'}">
			    <script>
			        alert("로그아웃 완료");
			    </script>
		</c:if>
	<header>
		
		<div class="nav-wrap">

			<h1 class="logo">
				<a href="/">LOGO</a>
			</h1>

			<nav class="main-menu">
				<a href="#">메뉴소개</a> <a href="BoardServlet?command=board_list">자유게시판</a>
			</nav>

			<div class="user-menu">
				<a href="member/memberLogin.jsp" class="login">로그인</a> 
				<a href="#" class="signup">회원가입</a>
			</div>

		</div>
	</header>

	<section>
		<div class="slider">
			<img src="img/slider.jpg" alt="mainImg">
		</div>

	</section>

	<footer>
		<div class="inner">
			<p class="copy">COPYRIGHT ⓒ 2025 김백함정. ALL RIGHTS RESERVED.</p>
		</div>
	</footer>

</body>

</html>