<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
<form method="post" class="loginForm" style="width: 600px; height: 700px;" >
<h2 id=st>학생이름</h2>
<div style=" height: 85%;">         
<input class="btn" type="button" onclick="go_user()" value="main" style="top: 90%;">  
	<table id =tb>
			<col width="30%"><col width="30%"><col width="30%">
			<tr>
				<td>입실 시간</td><td>퇴실 시간</td><td>출석 결과</td>
			</tr>
	</table>
</div>
</form>
</body>
<script type="text/javascript">
function go_user() {
	$('#board').hide();
	$('#user').show();
}
function boardListUP(){
	function list(e){
		for(i in e)
			$('#tb').append('<tr>'
			+'<td>'+e[i].come_in+'</td><td>'
			+e[i].go_out+'</td><td>'
			+e[i].result+'</td></tr>')
	}
	var input = $('.loginForm').find('input');
	var data = {'st_id':input.eq(0).val(),};
	ajaxfunction(data,'/boardList',list);
}
function boardreset() {
	$('#tb').text('')
	$('#tb').append("<col width='30%'><col width='30%'><col width='30%'>")
	$('#tb').append("<tr><td>입실 시간</td><td>퇴실 시간</td><td>출석 결과</td></tr>")
}

</script>
</html>