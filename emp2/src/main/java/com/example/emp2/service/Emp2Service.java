package com.example.emp2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp2.mapper.Emp2Mapper;
import com.example.emp2.vo.Emp2VO;
import com.github.pagehelper.PageHelper;

@Service
public class Emp2Service {
	@Autowired
	private Emp2Mapper mapper2; 
	
	public List<Emp2VO> getEmp2List(int deptno){
		
		int rows = mapper2.updateEmp2Comm(deptno); //update
		if(rows > 0) {
			List<Emp2VO> list = mapper2.selectEmp2ByDeptno(deptno);
			// 가장 급여가 높은 사람 empno 찾아내기
			int sal = 0; //급여
			List<Integer> empNoList = new ArrayList<Integer>();
			for(Emp2VO vo : list) {
				if(sal < vo.getSal()) {
					sal = vo.getSal();
					empNoList.add(vo.getEmpno()); //급여 많이 받는 사원 list에 추가 
				}
			}
			for(int empno : empNoList) {
				System.out.println("가장 급여를 많이 받는 사원 번호 : " + empno);
			}
			list = mapper2.selectEmp2ByDeptno(deptno); //삭제된 데이터 조회
			return list;
		}
		return null; //rows가 0이면 null 리턴!
	}
	
	//전체 사원 조회
	public List<Map<String, Object>> getEmp2PageList(int page){
		//필요에 따라 고객 요구 사랑이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return mapper2.selectEmp2();
	}
	
	//사원 통계 조회
	public Map<String, Object> getEmp2Statistics(){
		return mapper2.selectEmp2Statistics();
	}
	
	//사원 저장 
	public int setEmp2(Emp2VO vo) {
		//이미 가입된 사원 번호인지 체크하기
		int empno = vo.getEmpno(); //사원번호를 불러온다.
		int count = mapper2.selectCountByEmpno2(empno); //이미 가입된 회원 체크 쿼리 호출!
		if(count > 0) { //만약에 count가 1이면 이미 가입된 사원
			return 0;
		}
		return mapper2.insertEmp2(vo);
	}
	
	//특정 사원 조회
	public Emp2VO getEmp2ByEmpno(int empno) {
		return mapper2.selectEmp2ByEmpno(empno);
	}
	
	//특정 사원 정보 수정
	public int getEmp2Update(Emp2VO vo) {
		return mapper2.updateEmp2(vo);
	}
	
	//특정 회원 탈퇴(삭제) : 컬럼(is_use)만 수정
	public int getFireEmp2(int empno) {
		return mapper2.fireEmp2(empno);
	}
}
