const video = document.getElementById('video')

Promise.all([
	faceapi.nets.faceLandmark68Net.loadFromUri('/models'),
	faceapi.nets.faceRecognitionNet.loadFromUri('/models'),
	faceapi.nets.ssdMobilenetv1.loadFromUri('/models'),
]).then(startVideo)

function startVideo(){
	navigator.getUserMedia(
		{video:{}},
		stream=>video.srcObject = stream,
		err=>console.error(err)
	)
}

video.addEventListener('play',async () => {
	var labels =[];	
	$.ajax({
		url:'/labels',	//jsp주소
		type:'POST',
	 	processData: false,    // 반드시 작성
	 	contentType: false,    // 반드시 작성
	    success:function(e){
		  labels = e;
		},
		error:function(jqXHR, textStatus, errorThrown){
			alert("데이터 전송 실패: " + textStatus+": " + errorThrown);
		}
	}); 

	const resultid = document.getElementById('result');
	resultid.innerText='시스템 준비중 입니다 '
	const canvas = faceapi.createCanvasFromMedia(video)
	document.body.append(canvas)

	const displaySize = { width: video.width, height: video.height }
	faceapi.matchDimensions(canvas, displaySize)
	var isresult = false
	var isOne = false
	var labeledFaceDescriptors;
	var faceMatcher;
	setInterval(async () => {
		if(!isOne){
			labeledFaceDescriptors = await loadLabeledImages(labels)
			faceMatcher = new faceapi.FaceMatcher(labeledFaceDescriptors)
			if(labeledFaceDescriptors!=null&& faceMatcher!=null)
				isOne=true;
		}

	    const detections = await faceapi.detectAllFaces(video).withFaceLandmarks().withFaceDescriptors()
	    const resizedDetections = faceapi.resizeResults(detections, displaySize)
	    canvas.getContext('2d').clearRect(0, 0, canvas.width, canvas.height)
	    const results = resizedDetections.map(d => faceMatcher.findBestMatch(d.descriptor))
		
	    results.forEach((result, i) => {
		const box = resizedDetections[i].detection.box
		faceapi.draw.drawFaceLandmarks(canvas, resizedDetections)
		if(!isresult&&result.toString().split(' ')[[0]] != 'unknown' ){
			isresult=true
			var st_name=result.toString();
			resultid.innerText = st_name; 
			ajaxfunction({"st_name":st_name},'/faceMechMember',facetoName);
		}
		
		const drawBox = new faceapi.draw.DrawBox(box, {label: result.toString()})
		drawBox.draw(canvas) 
		})
	}, 100) 
})

function loadLabeledImages(labels){
	return Promise.all(
		labels.map(async label =>{
			const descriptions = [];
			for(let i=1;i<=2;i++){
				const img = await faceapi.fetchImage(`/images/${label}/${i}.png`)
				const detections = await faceapi.detectSingleFace(img).withFaceLandmarks().withFaceDescriptor()
				descriptions.push(detections.descriptor)
			}
			return new faceapi.LabeledFaceDescriptors(label, descriptions)
		})
	)
}

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
function facetoName(e){
	if(e.process!='성공')return
	const resultid = document.getElementById('result');
	const input = document.createElement('input')
	resultid.innerText = ''
	resultid.append(input)
	input.type = 'button'
	input.value = '출석 체크'
	input.className = 'btn'
	input.onclick=function(){
		alert('출석이 확인 되었습니다')
		window.close();
	}
}