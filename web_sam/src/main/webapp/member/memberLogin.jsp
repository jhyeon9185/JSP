<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

		<script src="${pageContext.request.contextPath}/script/member.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<header>
        <div class="nav-wrap">
            
            <nav class="main-menu">
                <a href="#">메뉴소개</a>
                <a href="#">자유게시판</a>
            </nav>
        </div>
    </header>

    <section>
        <div class="wrap">
        	
            <form action="${pageContext.request.contextPath}/MemberServlet" method="post" name="frm" onsubmit="return loginCheck()">
                    <div class="login_fom">
                        <input type="hidden" name="command" value="member_login">

                        <h1 class="login-title">로그인</h1>

                        <p class="login-id">
                            <input type="text" name="userid" class="form_input-text" placeholder="아이디" >
                        </p>

                        <p class="login-pwd">
                            <input type="password" name="pwd" class="form_input-text" placeholder="비밀번호">
                        </p>

                        <p class="login-signup">
                            <input type="submit" value="로그인" class="login-btn">
                                &nbsp;&nbsp;
                            <input type="button" value="회원가입" class="sign-btn" onclick="location.href='MemberServlet?command=member_write'">
                        </p>
                    </div>
            </form>
        </div>
    </section>

    <footer>
        <div class="inner">
            <p class="copy">COPYRIGHT ⓒ 2025 김백함정. ALL RIGHTS RESERVED.</p>
        </div>
    </footer>
</body>
</html>
