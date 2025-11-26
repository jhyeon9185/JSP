<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
	<h2>회원 정보 수정</h2>

	<form action="${pageContext.request.contextPath}/MemberServlet" method="post" name="frm">
	
	    <input type="hidden" name="command" value="member_update">
	    아이디: <input type="text" value="${loginUser.userid}" readonly><br>
	    이름: <input type="text" name="name" value="${loginUser.name}"><br>
	    이메일: <input type="text" name="email" value="${loginUser.email}"><br>
	    <input type="submit" value="수정하기">
	    
	</form>
	
</body>
</html>