package memory.dao;

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
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<memoryDTO> list = 
						sqlSession.selectList("mybatis.memoryMapper.memoryBoardList" , map);
		
		
		return list;
	}
	
	//총 글수 얻기
	public int getTotalMemory() {
		return sqlSession.selectOne("mybatis.memoryMapper.getTotalMemory");
	}
	
	//select : 글 하나 얻어오기
	public int memoryBoardView() {
		return sqlSession.selectOne("mybatis.memoryMapper.memoryBoardView");
	}
	
}
