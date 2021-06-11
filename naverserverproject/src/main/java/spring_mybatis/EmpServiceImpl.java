package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao;
	
	@Override
	public EmpVO getOneEmp(int employee_id) {
		return dao.getOneEmp(employee_id);
	}

	@Override
	public List<EmpVO> getAllEmp() {
		return dao.getAllEmp();
	}

	@Override
	public List<EmpVO> getPagingEmp(int page[]) {
		return dao.getPagingEmp(page);
	}

	@Override
	public void registerEmp(EmpVO vo) {//사원등록서비스기능-3개sql
		System.out.println("성=" + vo.getLast_name() );
		if(vo.getLast_name() != null) {
			EmpVO vo2 = dao.checkEmp(vo);//  사번 이메일 
			String job_id = dao.checkJob(vo);
			System.out.println("vo2=" + vo2 + ", job_id=" + job_id);
			if(vo2 == null && job_id != null) {
				dao.insertEmp(vo);
			}
					
		}

		
	}

	
//	@Override
//	public void insertEmp(EmpVO vo) {
//		dao.insertEmp(vo);
//		
//	}
//
//	@Override
//	public void updateEmp(EmpVO vo) {
//		dao.updateEmp(vo);
//		
//	}
//
//	@Override
//	public void deleteEmp(int employee_id) {
//		dao.deleteEmp(employee_id);
//		
//	}
//
//	@Override
//	public List<EmpVO> getPageEmp(int[] nums) {
//		return dao.getPageEmp(nums);
//	}
//
//	@Override
//	public void insertEmp2(EmpVO vo) {
//		dao.insertEmp2(vo);
//		
//	}
//
//	@Override
//	public List<EmpVO> getEmpDept(List<Integer> deptList) {
//		return dao.getEmpDept(deptList);
//	}
//
//	@Override
//	public void updateEmpMap(Map<String, String> map) {
//		dao.updateEmpMap(map);
//		
//	}
//	
//
//	
	
	
}
