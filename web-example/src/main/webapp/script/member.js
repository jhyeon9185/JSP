//	로그인 ==> 아이디, 비밀번호 입력했는지 체크
function loginChek(){
	
	const loginfoam = document.loginfoam;
	
	if(!loginfoam.userid.value.trim()){
		alert("아이디 입력하세요.");
		loginfoam.userid.focus();
		return false;
	}
	
	if(!loginfoam.pwd.value.trim()){
		alert("암호를 입력하세요.");
		loginfoam.pwd.focus();
		return false;
	}
	return true;
}

