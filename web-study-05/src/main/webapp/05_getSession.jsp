<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		Object id = session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		int age = (Integer)session.getAttribute("age");
	
	%>
	
	
	id = <%= id %> <br>
	pw = <%= pw %> <br>
	age = <%= age %> <br>
</body>
</html>