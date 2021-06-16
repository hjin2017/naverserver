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
		<div><input class="btn" type="button" onclick="window.open('face_check', 'ss2s','width=742, height=620, scrollbars=no, resizable=no, toolbars=no, menubar=no')" value="출석 체크"></div>
		<div><input class="btn" type="button" onclick="hjh_login()" value="출결 현황"></div>
		<div><input class="btn" type="button" onclick="logout()" value="logout"></div>
</form>
</body>
<script>
function logout(){
		$('#login').show();
		$('#user').hide();
}
function add() {
	window.open("addperson",$('#userName').text(),"width=742, height=620, scrollbars=no, resizable=no, toolbars=no, menubar=no")
}
</script>
</html>