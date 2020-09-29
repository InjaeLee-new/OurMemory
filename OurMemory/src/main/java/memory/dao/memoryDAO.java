package memory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import memory.dto.memoryDTO;

@Repository
public class memoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int memoryBoardWrite(memoryDTO memoryDTO) {
		int result = sqlSession.insert("mybatis.memoryMapper.memoryBoardWrite", memoryDTO);
		return result;
	}
	
	//select : 목록 List 불러오기
	public List<memoryDTO> memoryBoardList(int startNum, int endNum) {
		List<memoryDTO> list = new ArrayList<memoryDTO>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return list;
	}
}
