package com.example.emp2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.emp2.vo.Emp2VO;

@Mapper
public interface Emp2Mapper {

	//부서번호 사원 조회
	public List<Emp2VO> selectEmp2ByDeptno(int deptno);
	//사원 급여 별로 comm(보너스) 지급
	public int updateEmp2Comm(int deptno);
	//사원 삭제
	public int deleteEmp2(int empno);
	//전체 사원 조회
	public List<Map<String, Object>> selectEmp2();
	//통계 쿼리 조회
	public Map<String, Object> selectEmp2Statistics();
	//사원 저장
	public int insertEmp2(Emp2VO vo);
	//특정 사원 조회
	public Emp2VO selectEmp2ByEmpno(int empno);
	//특정 사원 정보 수정
	public int updateEmp2(Emp2VO vo);
	//특정 사원 회원 탈퇴(삭제)
	public int fireEmp2(int empno);
	//이미 가입된 사원인지 아닌지 체크
	public int selectCountByEmpno2(int empno);
	
}
