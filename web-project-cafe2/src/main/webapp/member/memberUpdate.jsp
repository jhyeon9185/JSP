<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member_update.css">
	</head>

	<body>
	
		<h2>회원 정보 수정</h2>

		<form action="${pageContext.request.contextPath}/MemberServlet" method="post" name="frm">

			<input type="hidden" name="command" value="member_update">
			
			아이디 : <input type="text" name="userid" value="${loginUser.userid}" readonly><br>
			이름 : <input type="text" name="name" value="${loginUser.name}" readonly><br>
			비밀번호 : <input type="password" name="pwd" value="${loginUser.pwd}" ><br>
			이메일 : <input type="text" name="email" value="${loginUser.email}"><br>
			폰 번호 : <input type="text" name="phone" value="${loginUser.phone}" ><br>
			
			<input type="submit" value="수정하기">

		</form>

	</body>

	</html>