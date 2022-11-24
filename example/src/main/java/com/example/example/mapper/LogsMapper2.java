package com.example.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.example.vo.Logs2VO;

@Mapper
public interface LogsMapper2 {

	public int insertLogs(Logs2VO vo);//로그 추가
	public List<Map<String, Object>> selectLogs(); //로그 조회
	public Logs2VO selectLogsByLogId(int logsId); //로그 상세 조회
	
}
