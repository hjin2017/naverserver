<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
		<div id = login >
			<%@include file="login.jsp" %>
		</div>	
			<div id = 'user'style="display: none;">	
			<%@include file="user.jsp" %>
		</div>	
			<div id= 'hjh_owner_show' style="display:none;">
		</div>
</body>
</html>