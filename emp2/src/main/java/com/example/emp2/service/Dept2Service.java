package com.example.emp2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp2.mapper.Dept2Mapper;
import com.example.emp2.mapper.Emp2Mapper;
import com.example.emp2.vo.Dept2VO;
import com.example.emp2.vo.Emp2VO;
import com.github.pagehelper.PageHelper;

@Service
public class Dept2Service {
	@Autowired
	private Dept2Mapper dept2Mapper;
	
	// 사원 전체 조회
	public List<Map<String, Object>> getDept2PageList(int page){
		// 필요에 따라 고객 요구사항이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return dept2Mapper.selectDept2();
	}
	// 부서 추가
	public int setDept2(Dept2VO vo) {
		int deptno = vo.getDeptno();
		int count = dept2Mapper.selectCountByDeptNo2(deptno);
		if(count > 0) {
			return 0;
		}
		return dept2Mapper.insertDept2(vo);
	}
	// 특정 부서 조회
	public Dept2VO getDept2ByDeptno(int deptno) {
		return dept2Mapper.selectDept2ByDeptno(deptno);
	}
	// 특정 부서 정보 수정
	public int getDept2Update(Dept2VO vo){
		return dept2Mapper.updateDept2(vo);
	}
	// 특정 부서 삭제(is_use)
	public int getFireDept2(int deptno) {
	  return dept2Mapper.fireDept2(deptno);
	}
	
}
