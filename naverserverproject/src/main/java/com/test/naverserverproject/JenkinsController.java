package com.test.naverserverproject;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JenkinsController {
	
	@Autowired
	MemberDAO serviceMemberDao;
	
	@RequestMapping("/jenkins")
	public String jenkins() {
		return "main";
	}
	
	@RequestMapping(value="/chkUpdate")
	@ResponseBody
	public void test(StudentVO student) {
		  File file = new File("../img"); 
		  String[] files = file.list();
		  
		  System.out.println("Listing contents of " + file.getPath()); 
		  for(int i=0 ; i< files.length ; i++) 
		  { System.out.println(files[i]); }

		//System.out.println(student);
		String data = student.getImg().split(",")[1];

		byte[] imageBytes= Base64.getDecoder().decode(data); 
		System.out.println(imageBytes);
		try {
			String path = "../img/"+student.getName();
				File Folder = new File(path);
				System.out.println(data);
			if(!Folder.exists()) {
				Folder.mkdir();
			}
			
			if(Folder.list().length>=2) {
				Random rand = new Random();
				BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));
				System.out.println(rand.nextInt(1));
				ImageIO.write(bufImg, "png",new File(path +"/"+(rand.nextInt(1)+1)+".png"));
			}
			
			if(Folder.list().length<2) {
				BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));
				ImageIO.write(bufImg, "png",new File(path +"/1.png"));
				ImageIO.write(bufImg, "png",new File(path +"/2.png"));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("실패");
		}
		
		System.out.println("성공");
		
		//stddao.updateImg(student);
		
	}
	@RequestMapping(value="/labels")
	@ResponseBody
	String[] labels() {
		  File file = new File("../img"); 
		  String[] files = file.list();
		  return files;
	}
	
	@RequestMapping("/sing_up")
	public String sing_up() {
		return "sing_up";
	}
	
	@RequestMapping("/hjh_join")
	@ResponseBody
	public String hjh_join(String st_id,String st_name,String st_phon,String pass) {
		MemberVO vo = new MemberVO(st_id,st_name,st_phon,pass);
		MemberVO idvo= serviceMemberDao.getOneMember(st_id);
		String eM = "";
		//주소 좌표 전환 메소드를 추가해야함
		if(idvo !=null) {
			eM = "\"id가 중복 되었습니다.\"";
			return "{\"process\":"+eM+"}"; 
		}
		eM = "\"성공\"";
		serviceMemberDao.insertMember(vo);
		 return "{\"process\":"+eM+"}"; 
	}
	
	@RequestMapping("/hjh_login")
	@ResponseBody
	public String hjh_login(String st_id,String pass) {
		MemberVO vo = new MemberVO(st_id,"","",pass);
		MemberVO idvo = serviceMemberDao.checkMember(vo);
	
		String eM = "";
		//주소 좌표 전환 메소드를 추가해야함
		if(idvo ==null) {
			eM = "\"실패\"";
			return "{\"process\":"+eM+"}"; 
		}
		eM = "\""+idvo.getSt_name()+"\"";
		 return "{\"process\":"+eM+"}"; 
	}	
	@RequestMapping("/addperson")
	public String addperson() {
		return "face_registration";
	}
	@RequestMapping("/face_check")
	public String face_check() {
		return "attendance_check";
	}
	@RequestMapping("/faceMechMember")
	@ResponseBody
	public String faceMechMember(String st_name) {
		String name =null; //
		String arry[] = st_name.split(" ");
		name = serviceMemberDao.getNameMember(arry[0]);
		//System.out.println(name);
		String eM = "";
		//주소 좌표 전환 메소드를 추가해야함
		if(name ==null) {
			eM = "\"사진을 다시 등록 해주세요\"";
			return "{\"process\":"+eM+"}"; 
		}
		eM = "\"성공\"";
		 return "{\"process\":"+eM+"}"; 
	}	
	
	@RequestMapping("/boardList")
	@ResponseBody
	public ArrayList<BoardVO> boardList(String st_id) {
		  ArrayList<BoardVO> arrDto = (ArrayList<BoardVO>)serviceMemberDao.getBoard(st_id);
		  System.out.println(arrDto);
		 return  arrDto;
		
	}	
}
