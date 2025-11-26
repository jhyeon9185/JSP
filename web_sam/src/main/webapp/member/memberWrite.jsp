<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="${pageContext.request.contextPath}/script/member.js"></script>
</head>
<body>
	
	<h2>회원 가입</h2>
	'*' 표시 항목은 필수 입력 항목입니다.
	<form action="${pageContext.request.contextPath}/MemberServlet" method="post" name="frm">
	
		<input type="hidden" name="command" value="member_id_chek">
		
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20">*</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
				<input type="text" name="userid" id="userid" size="20">*
				<input type="button" value="중복 체크" onclick="idCheck()">
				<input type="hidden" name="reid">

				</td>
			</tr>

			<tr>
				<td>암 호</td>
				<td>
				<input type="password" name="password" size="20">*</td>
			</tr>

			<tr height="30">
				<td width="80">암호 확인</td>
				<td><input type="password" name="pwd_check" size="20">*</td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="확인" onclick="return joinCheck()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="reset" value="취소">
				</td>
			</tr>

			<tr>
				<td colspan="2">${message }</td>
			</tr>

		</table>
	</form>
</body>
</html>