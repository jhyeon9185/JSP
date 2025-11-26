// -------------------------
// 로그인 체크
// -------------------------
function loginCheck() {
	const frm = document.frm;

	if (!frm.userid.value.trim()) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
	}

	if (!frm.pwd.value.trim()) {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}

	return true;
}


// -------------------------
// 아이디 중복 체크
// -------------------------
function idCheck() {
	const frm = document.frm;

	if (!frm.userid.value.trim()) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return;
	}

	const url = contextPath + "/MemberServlet?command=member_id_check&userid=" + encodeURIComponent(frm.userid.value);

	// 새 창 열기
	window.open(
	        url,
	        "idCheckWindow", // _blank 사용하지 않기
	        "toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=700,height=500"
	    );
}


// -------------------------
// 중복 확인창에서 아이디 선택 후 부모창으로 전달
// -------------------------
function idok(userid) {
	// opener = 부모창
	if (window.opener && window.opener.document && window.opener.document.frm) {
		const parentFrm = window.opener.document.frm;

		parentFrm.userid.value = userid;
		parentFrm.reid.value = userid;
		window.close();
		
	} else {
		alert("부모창이 존재하지 않습니다.");
	}
}


// -------------------------
// 회원가입 체크
// -------------------------
function joinCheck() {
	const frm = document.frm;

	if (!frm.name.value.trim()) {
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}

	if (!frm.userid.value.trim()) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
	}

	if (frm.userid.value.length < 3) {
		alert("아이디는 3글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}

	if (!frm.pwd.value.trim()) {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}

	if (frm.pwd.value !== frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd_check.focus();
		return false;
	}

	if (!frm.reid.value.trim()) {
		alert("아이디 중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}

	return true;
}
