<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/script/member.js"></script>
<style>
body {
	background: #f3f4f7;
	font-family: 'Noto Sans KR', sans-serif;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	margin-top: 40px;
	font-size: 28px;
	color: #333;
	font-weight: 700;
}

.form-container {
	width: 420px;
	background: #fff;
	margin: 40px auto;
	padding: 40px 35px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
	border-radius: 15px;
}

.form-container table {
	width: 100%;
}

.form-container td {
	padding: 10px 0;
	font-size: 16px;
	color: #333;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 15px;
	box-sizing: border-box;
	background: #fafafa;
}

input[type="button"] {
	margin-top: 5px;
	padding: 8px 12px;
	font-size: 14px;
	background: #4a6cf7;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
}

input[type="submit"] {
	width: 100%;
	padding: 12px;
	background: #4678ff;
	color: white;
	border: none;
	border-radius: 8px;
	font-size: 17px;
	margin-top: 15px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background: #3567ff;
}


.radio-group {
	margin-top: 5px;
}

</style>
</head>

<body>

	<h2>회원 가입</h2>

	<div class="form-container">
		<form action="${pageContext.request.contextPath}/MemberServlet"
			method="post" name="frm">

			<input type="hidden" name="command" value="member_sign">

			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" size="20"></td>
				</tr>

				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" id="userid" size="20">
						<input type="button" value="중복 체크" onclick="idCheck()"> <input
						type="hidden" name="reid"></td>
				</tr>

				<tr>
					<td>암호</td>
					<td><input type="password" name="password" size="20"></td>
				</tr>

				<tr>
					<td>암호 확인</td>
					<td><input type="password" name="pwd_check" size="20"></td>
				</tr>

				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" size="20"></td>
				</tr>

				<tr>
					<td>폰</td>
					<td><input type="text" name="phone" size="20"></td>
				</tr>

				<tr>
					<td>관리자</td>
					<td class="radio-group"><input type="radio" name="admin"
						value="0" checked> 일반회원 <input type="radio" name="admin"
						value="1"> 관리자</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="확인" onclick="return joinCheck()" > 
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>

</html>