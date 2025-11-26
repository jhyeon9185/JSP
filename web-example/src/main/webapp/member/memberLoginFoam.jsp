<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
	<script src="${pageContext.request.contextPath }/script/member.js"></script>
	
</head>
<body>
	<div class="main-login">
		<form action="${pageContext.request.contextPath}/MemberServlet" 
		method="post" name="loginfoam" onsubmit="return loginChek()">
			<div class="main-login-form">
				<input type="hidden" name="command" value="member_login">
				
				<h1 class="main-login-title">로그인</h1>
				
				<div class="login-id-box">
					<input type="text" name="userid" placeholder="아이디">
				</div>
				
				<div class="login-pwd-box">
					<input type="password" name="pwd" placeholder="비밀번호">
				</div>
				
				<div class="login-sign-box">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입"
					onclick="location.href='${pageContext.request.contextPath}/MemberSerlvet?command=member_signup'">
				</div>
			
			</div>		
		</form>
	
	</div>
</body>
</html>