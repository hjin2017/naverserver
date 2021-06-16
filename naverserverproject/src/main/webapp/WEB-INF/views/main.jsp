<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teamproject</title>
<script src ="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
});
//공통 함수 모임
function ajaxfunction(data,url,fun) {
var test =	{
		url:'',
		type: 'post' , 
		dataType: 'json' ,
		data:'',
		success: function(e){fun(e);},
		error:function(request,status,error){
			 console.log("code:"+request.status+"\n"+"error:"+error);
		}
}
		
test.url = url;
test.data = data;	
$.ajax(test);
}
</script>
</head>
<body>
	<header>
		<%-- <%@include file="menu/menu.jsp" %> --%>
	</header>
	<article>
	 		<%@include file="show.jsp" %>
	 </article>
	 <footer>
		<div id="main_foot" >
			<%-- <%@include file="foot.jsp" %> --%>
		</div>
	</footer>
</body>
</html>