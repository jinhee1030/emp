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

import com.example.emp2.service.Dept2Service;
import com.example.emp2.service.Emp2Service;
import com.example.emp2.vo.Dept2VO;
import com.example.emp2.vo.Emp2VO;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/em1")
@CrossOrigin
public class Dept2Controller {
	
	@Autowired
	private Dept2Service dept2Service;
	
	// 전체 사원 조회
	// PageInfo : 페이징 처리 도와주는 라이브러리!
	// 쿼리스트링으로 수정 ?page=3
	@GetMapping("/dept2")
	public PageInfo<Map<String, Object>> callDept2Page(@RequestParam int page){
		List<Map<String, Object>> list = dept2Service.getDept2PageList(page);
		int navigatePages = 5; // 한 블록에 보여줄 페이지 수( ex 네이버 웹툰은 1블록에 1페이지)
		return new PageInfo<Map<String, Object>>(list, navigatePages);
	}
	//부서 등록
	@PostMapping("/dept2")
	public int callDept2Insert(@RequestBody Dept2VO vo) {
		return dept2Service.setDept2(vo);
	}
	// 특정 부서 조회
	@GetMapping("/dept2/deptno/{deptno}")
	public Dept2VO callDept2ByDeptno(@PathVariable int deptno) {
		return dept2Service.getDept2ByDeptno(deptno);
	}
	// 특정 부서 정보 수정
	@PatchMapping("/dept2")
	public int callDept2Update(@RequestBody Dept2VO vo) {
		return dept2Service.getDept2Update(vo);
	}
	// 특정 부서 삭제(is_use)
	@PatchMapping("/dept2/deptno/{deptno}")
	public int callDept2UseUpdate(@PathVariable int deptno) {
	  return dept2Service.getFireDept2(deptno);
	}
		
}
