package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Mapper //@MapperScan
@Repository("dao")//@ComponentScan
public interface EmpDAO {
	
	public EmpVO getOneEmp(int employee_id) ; //<select id="getOneEmp"
	
	public  List<EmpVO> getAllEmp() ; //<select id="getAllEmp"  호출
	
	public List<EmpVO> getPagingEmp(int page[]);//<mapper namespace  "xxx.EmpDAO"
	
	public EmpVO checkEmp(EmpVO vo); //사번 , 이메일 중복 검사- 결과 존재하면 사번이나 이메일 등록 불가
	
	public String checkJob(EmpVO vo);////job_id -jobs테이블 조회 존재 여부 - 결과 존재하면 직종 등록 가능 
	
	public void insertEmp(EmpVO vo);
	
	
//	public void insertEmp(EmpVO vo) {
//		session.insert("kdigital.insertEmp", vo);
//	}
//	
//	public void updateEmp(EmpVO vo) {
//		session.update("kdigital.updateEmp", vo);
//	}
//
//	public void deleteEmp(int employee_id) {
//		session.delete("kdigital.deleteEmp", employee_id);
//	}
//	
//	public List<EmpVO> getPageEmp(int[] nums){
//		return session.selectList("kdigital.pageEmp", nums);
//	}
//	
//	public void insertEmp2(EmpVO vo) {
//		session.insert("kdigital.insertEmp2", vo);
//	}
//	
//	public List<EmpVO> getEmpDept(List<Integer> deptList){
//		return session.selectList("kdigital.selectwithlist", deptList);
//	}
//	
//	public void updateEmpMap(Map<String, String> map) {
//		session.update("kdigital.updatewithmap", map);
//	}
}






