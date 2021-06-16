<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@charset "EUC-KR";

.loginForm {

  width:300px;
  height:400px;
  background-color:#FFFFFF;
  text-align:center;
  position:relative;
  border-radius: 15px;
}

.loginForm h2{
  padding: 10px;
  text-align: center;
  margin: 30px; 
}

.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  border-radius: 10px;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}

body {
margin:0;
padding: 0;
widows: 100vw;
height: 100vh;
display: flex;
justify-content: center;
align-items: center;
background-color:yellow;
}
</style>
</head>
<body>
<form method="post" class="loginForm" >
		<h2>로그인</h2>
		<div class="idForm"><input class="id" type="text" placeholder="ID" value=""></div>
		<div class="passForm"><input class="pw" type="password" placeholder="PW" value=""></div>
		<br>
		<div><a href='#hjh_user_login'  onclick="window.open('sing_up', 'ss1s','width=560, height=400, scrollbars=no, resizable=no, toolbars=no, menubar=no')">회원 가입하기</a> </div>
		<br>
		<div><input class="btn" type="button" onclick="hjh_login()" value="login"></div>
</form>

</body>
<script>
function hjh_login(){
	function login(e){
		if(e.process!='실패'){
			alert('성공')
			$('#login').hide();
			$('#user').show();
			input.eq(0).val('')
			input.eq(1).val('')
			$('#userName').text(e.process);
			return;
		}
	
	}
	
	var input = $('.loginForm').find('input');
	var str = '';
	if(input.eq(0).val()=='')
		str += 'id를 입력 하세요\n';
	if(input.eq(1).val() == ''||input.eq(1).val().length<8 )
		str +='비밀번호를 확인 하세요\n';
	if(str !='')
		{alert(str); return;}
	
	ajaxfunction({'st_id':input.eq(0).val(),'pass':input.eq(1).val()},'/hjh_login',login)
}
</script>
</html>