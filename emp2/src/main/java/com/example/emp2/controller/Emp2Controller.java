package com.example.emp2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp2.service.Emp2Service;
import com.example.emp2.vo.Emp2VO;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/em1")
@CrossOrigin
public class Emp2Controller {
	
	@Autowired
	private Emp2Service service;
	
	@GetMapping("/emp2/deptno/{deptno}")
	public List<Emp2VO> callEmp2(@PathVariable int deptno){
		return service.getEmp2List(deptno);
	}
	
	//전체 사원 조회
	@GetMapping("/emp2")
	public PageInfo<Map<String, Object>> callEmp2Page(@RequestParam int page){
		List<Map<String, Object>> list = service.getEmp2PageList(page);
		int navigatePages = 5;
		return new PageInfo<Map<String, Object>>(list, navigatePages);
	}

	// 사원 추가
	@PostMapping("/emp2")
	public int callEmp2(@RequestBody Emp2VO vo){
		return service.setEmp2(vo);
	}
	// 사원정보 통계 조회
	@GetMapping("/emp2/statistics")
	public Map<String, Object> callStatistics2(){
		return service.getEmp2Statistics();
	}
	// 특정 사원 조회
	@GetMapping("/emp2/empno/{empno}")
	public Emp2VO callEmp2ByEmpno(@PathVariable int empno) {
		return service.getEmp2ByEmpno(empno);
	}
	// 특정 사원 정보 수정
	@PatchMapping("/emp2")
	public int callEmp2Update(@RequestBody Emp2VO vo) {
		return service.getEmp2Update(vo);
	}
	// 특정 회원 탈퇴(삭제) (body가 아니라 path로 데이터를 받자)
	@PatchMapping("/emp2/empno/{empno}")
	public int callEmp2UseUpdate(@PathVariable int empno) {
		return service.getFireEmp2(empno);
	}
		
}
