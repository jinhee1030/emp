package com.example.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.example.vo.Dept2VO;


@Mapper
public interface DeptMapper2 {

	// 전체 사원 조회
		public List<Map<String, Object>> selectDept();
		//부서 등록
		public int insertDept(Dept2VO vo);
		//이미 있는 부서인지 아닌지 체크
		public int selectCountByDeptNo(int deptno);
		// 특정 부서 조회
		public Dept2VO selectDeptByDeptno(int deptno);
		// 특정 부서 정보 수정
		public int updateDept(Dept2VO vo);
		// 특정 부서 삭제(is_use)
		public int fireDept(int deptno);
}
