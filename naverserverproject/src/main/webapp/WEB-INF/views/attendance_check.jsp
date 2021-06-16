<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="jquery-3.2.1.min.js"></script>
<script defer src='face-api.min.js'></script>
<script defer src='js/script.js'></script>
<script>
$(document).ready(function(){

});
</script>
<style>
canvas {
position:absolute;
}
video {
position:absolute;
}
#result{
position: fixed; bottom: 20px; width: 99%;
}
.btn {
  position:relative;
  left:49%;
   transform: translateX(-50%);
  width:100%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-size: 200%;
  border-radius: 10px;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  display:inline;
}
body{
background-color: yellow;
}
</style>
</head>
<body>
<video id ='video' width="720" height="560" autoplay muted></video>
<div id = "result">로딩중입니다 잠시만 기다려 주세요 </div>
</body>
</html>