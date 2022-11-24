package com.example.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.mapper.DeptMapper2;
import com.example.example.vo.Dept2VO;
import com.github.pagehelper.PageHelper;

@Service
public class DeptService2 {
	
	@Autowired
	private DeptMapper2 deptMapper2;
	
	// 사원 전체 조회
	public List<Map<String, Object>> getDeptPageList(int page){
		// 필요에 따라 고객 요구사항이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return deptMapper2.selectDept();
	}
	// 부서 추가
	public int setDept(Dept2VO vo) {
		int deptno = vo.getDeptno();
		int count = deptMapper2.selectCountByDeptNo(deptno);
		if(count > 0) {
			return 0;
		}
		return deptMapper2.insertDept(vo);
	}
	// 특정 부서 조회
	public Dept2VO getDeptByDeptno(int deptno) {
		return deptMapper2.selectDeptByDeptno(deptno);
	}
	// 특정 부서 정보 수정
	public int getDeptUpdate(Dept2VO vo){
		return deptMapper2.updateDept(vo);
	}
	// 특정 부서 삭제(is_use)
	public int getFireDept(int deptno) {
	  return deptMapper2.fireDept(deptno);
	}

}