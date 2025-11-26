<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>

		<body>

			<c:if test="${!empty message}">
				<div style="color:red; font-weight:bold;">
					${message}
				</div>
			</c:if>

			<% session.invalidate(); response.sendRedirect(request.getContextPath() + "/member/memberLogin.jsp" ); %>

		</body>

		</html>