package com.example.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.mapper.LogsMapper2;
import com.example.example.vo.Logs2VO;
import com.github.pagehelper.PageHelper;

@Service
public class LogsService2 {

	@Autowired
	private LogsMapper2 logsMapper2;
	
//	//로그 전체 조회
//	public List<LogsVO> getAllLogs(){
//		return logsMapper.selectLogs();
//	}
	public List<Map<String, Object>> getAllLogsPage(int page){
		// 필요에 따라 고객 요구사항이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return logsMapper2.selectLogs();
		
	}
	
	//로그 상세 조회
	public Logs2VO getLogs(int logId) {
		return logsMapper2.selectLogsByLogId(logId);
	}
}
