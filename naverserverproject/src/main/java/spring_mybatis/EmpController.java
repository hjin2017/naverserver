package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
//	//employees  테이블 전체 조회
	@RequestMapping("/emplist")
	public ModelAndView  getEmpList(){ //page 변수 전달값이 보여줄 페이지. 한페이지당 출력갯수 10개. 입사일이 빠른 사원부터 출력.
		//mybatis SqlSession--EmpDAO--EmpService하위-
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		//request.getAttirbute("emplist")  ${emplist}
		mv.setViewName("/mybatis/emplist");//WEB-INF/views/mybatis/emplist.jsp
		return mv;
		
	}
	
//	employees  테이블 page 변수 전달값이 보여줄 페이지. 한페이지당 출력갯수 10개. 입사일이 빠른 사원부터 출력.
	@RequestMapping("/emplistpage")
	public ModelAndView  getEmpList(int page){ //3
		//mybatis SqlSession--EmpDAO--EmpService하위-
		int rownum [] = new int[2];
		rownum[0] = (page - 1)*10 + 1 ; //21
		rownum[1] = page * 10 ; //30
		List<EmpVO> list = service.getPagingEmp(rownum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		//request.getAttirbute("emplist")  ${emplist}
		mv.setViewName("/mybatis/emplist");//WEB-INF/views/mybatis/emplist.jsp
		return mv;
		
	}
	
	
	//클라이언트 입력 id 파라미터 
	//  /empdetail url 
	//employees  테이블  - 1개 레코드 조회
	//model 로 생성
	// /mybatis/empdetail.jsp
	// empdetail.jsp 출력
	@RequestMapping("/empdetail")
	public ModelAndView getOneEmp(int id) {
		EmpVO vo = service.getOneEmp(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", vo);
		mv.setViewName("/mybatis/empdetail");
		return mv;
	}
	
	

	
	//추가폼 출력 / 사원정보 입력 - db insert - emplist 뷰
	//  employee_id, email -   중복x,
	// last_name not null
	// job_id, department_id, manager_id -  외래키
	
	@RequestMapping(value="/empadd", method=RequestMethod.GET)
	public String addEmp() {
		return "/mybatis/addform";
	}
	
	/*<FORM action="/empadd" method=post>
 사번<input type=text name="employee_id" ><br>
 이름<input type=text name="first_name" ><br>
 성<input type=text name="last_name" ><br>   
 이메일<input type=text name="email" ><br>
 직종<input type=text name="job_id"><br>*/
	@RequestMapping(value="/empadd", method=RequestMethod.POST)
	public String addEmp2(EmpVO vo) {
		//System.out.println(vo.toString());//null , 0
		service.registerEmp(vo);
		//return "/mybatis/emplist";==> emplist.jsp 이동(모델 없이)
		return "redirect:/emplist"; //==> /emplist  매핑 메소드 호출-모델-뷰
		
	}	
	
	
	//수정폼 
	@RequestMapping(value="/empmodify", method=RequestMethod.GET)
	public ModelAndView modifyEmp(int id) {
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		mv.addObject("emp", vo);
		mv.setViewName("/mybatis/modifyform");
		return mv;
	}
	//수정처리 메소드 추가
	
	
	//삭제
	@RequestMapping(value="/empdelete", method=RequestMethod.GET)
	public String deleteEmp(int id) {
		//service.xxxxx();
		return "redirect:/emplist";
	}	
	
	
}
