package com.example.emp2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.emp2.vo.Dept2VO;
import com.example.emp2.vo.Emp2VO;

@Mapper
public interface Dept2Mapper {
	
		// 전체 사원 조회
		public List<Map<String, Object>> selectDept2();
		//부서 등록
		public int insertDept2(Dept2VO vo);
		//이미 있는 부서인지 아닌지 체크
		public int selectCountByDeptNo2(int deptno);
		// 특정 부서 조회
		public Dept2VO selectDept2ByDeptno(int deptno);
		// 특정 부서 정보 수정
		public int updateDept2(Dept2VO vo);
		// 특정 부서 삭제(is_use)
		public int fireDept2(int deptno);
	
}
