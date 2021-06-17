<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<body>
<form method="post" class="loginForm" >
		<h2 id = userName>학생정보</h2>
		<div><input class="btn" type="button" onclick="add()" value="사진 등록"></div>
		<br><br><div><input class="btn" type="button" onclick="window.open('face_check', 'ss2s','width=742, height=620, scrollbars=no, resizable=no, toolbars=no, menubar=no')" value="출석 체크"></div>
		<br><br><div><input class="btn" type="button" onclick="billboard()" value="출결 현황"></div>
		<br><br><div><input class="btn" type="button" onclick="logout()" value="퇴실"></div>
</form>
</body>
<script>
function logout(){
		$('#login').show();
		$('#user').hide();
		var input = $('.loginForm').find('input');
		boardreset();
		input.eq(0).val('')
		input.eq(1).val('')
}
function billboard(){
	$('#board').show();
	$('#user').hide();
	$('#st').text($('#userName').text())
}
function add() {
	window.open("addperson",$('#userName').text(),"width=742, height=620, scrollbars=no, resizable=no, toolbars=no, menubar=no")
}
</script>
</html>