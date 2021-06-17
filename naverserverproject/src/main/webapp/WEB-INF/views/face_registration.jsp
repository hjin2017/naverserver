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
<style type="text/css">
.btn {
  position:relative;
  left:50%;
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
<div id ='aa' ></div>
</body>
<script type="text/javascript">
const video = document.getElementById('video')

startVideo()
function startVideo(){
	navigator.getUserMedia(
		{video:{}},
		stream=>video.srcObject = stream,
		err=>console.error(err)
	)
}
video.addEventListener('play',() => {
	const canvas = faceapi.createCanvasFromMedia(video)
	const input = document.createElement('input')
	document.getElementById('aa').append(input)
	input.type = 'button'
	input.value = '추가'
	input.className = 'btn'
	input.onclick= function(){
		var canvas2 = faceapi.createCanvasFromMedia(video);
		var context= canvas2.getContext('2d');
		context.drawImage(video, 0, 0, canvas.width, canvas.height);
		var src = canvas2.toDataURL();
		var formData = new FormData();
    	formData.append("name", name);
    	formData.append("img", src);
        	$.ajax({
       		url:'/chkUpdate',	//jsp주소
       		type:'POST',
       		data:formData,
        	 processData: false,    // 반드시 작성
             contentType: false,    // 반드시 작성
            success:function(){
             	alert("사진을 등록 하셨습니다");
    			window.close();
       		},
       		error:function(jqXHR, textStatus, errorThrown){
       			alert("데이터 전송 실패: " + textStatus+": " + errorThrown);
       		}
       	});  

		context.clearRect(0, 0, canvas.width, canvas.height)
	}
  })
</script>

</html>