
function loginCheck(){
	
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
		
	}// id if
	
	if(document.frm.pwd.value==""){
		alert("비밀번호를 입력해주세요.");
		frm.pwd.focus();
		return false;
			
	}// pwd if
	
	return true;
	
}// function

function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return ;
	}
	
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	
	// 새로운 브라우저 창 열린다.
	window.open(url, "_blank_1", "toolbar=no, scrollbox=yse, resizable-no, width=450, hieght=200");
}