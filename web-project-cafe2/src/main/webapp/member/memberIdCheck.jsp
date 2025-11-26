<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>
	
	<style>
		/* 전체 배경 */
body {
    font-family: "Noto Sans KR", sans-serif;
    background: #f5f6f7;
    margin: 0;
    padding: 0;
}

/* 제목 */
h2 {
    text-align: center;
    margin-top: 40px;
    font-size: 28px;
    font-weight: 600;
}

/* 카드 박스 */
form {
    width: 400px;
    margin: 30px auto;
    background: #fff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.08);
}

/* 라벨 (아이디 텍스트) */
form label {
    font-size: 16px;
    font-weight: 500;
    display: block;
    margin-bottom: 6px;
}

/* 입력창 */
form input[type="text"] {
    width: 100%;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 8px;
    margin-bottom: 15px;
    font-size: 15px;
    box-sizing: border-box;
}

form input[type="text"]:focus {
    outline: none;
    border-color: #4a6cf7;
    box-shadow: 0 0 0 2px rgba(74, 108, 247, 0.2);
}

/* 버튼 공통 */
form input[type="submit"],
form input[type="button"] {
    width: 100%;
    padding: 12px;
    font-size: 16px;
    font-weight: 600;
    border-radius: 8px;
    border: none;
    cursor: pointer;
}

/* 중복체크 버튼 */
form input[type="submit"] {
    background-color: #4a6cf7;
    color: white;
    margin-bottom: 10px;
}

form input[type="submit"]:hover {
    background-color: #3758d6;
}

/* 사용 버튼 */
form .cancel {
    background-color: #30c48d;
    color: white;
    margin-top: 10px;
}

form .cancel:hover {
    background-color: #27a876;
}

/* 메시지 스타일 */
.message {
    font-size: 15px;
    padding: 10px 0;
    text-align: center;
}

.message.error {
    color: #d9534f;
    font-weight: 600;
}

.message.success {
    color: #30c48d;
    font-weight: 600;
}
		
	
	</style>
	
	
</head>
<body>

	<h2>아이디 중복확인</h2>
	
	<form action="${pageContext.request.contextPath}/MemberServlet" method="get" name="frm">
		
		<input type="hidden" name="command" value="member_id_check">
		
		아이디 <input type=text name="userid" value="${userid}"> 
			<input type=submit value="중복체크">
		<br>

		<c:if test="${result == 1}">
			<script type="text/javascript">
            	opener.document.frm.userid.value = "";
         	</script>
         ${userid}는 이미 사용 중인 아이디입니다.
      	</c:if>

		<c:if test="${result==-1}">
      		${userid}는 사용 가능한 아이디입니다.
     	 <input type="button" value="사용" class="cancel" onclick="idok('${userid}')">

		</c:if>

	</form>
</body>
</html>