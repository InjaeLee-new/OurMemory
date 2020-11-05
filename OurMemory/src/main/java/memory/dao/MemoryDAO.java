package memory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import memory.dto.MemoryDTO;

@Repository
public class MemoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int memoryBoardWrite(MemoryDTO memoryDTO) {
		int result = sqlSession.insert("mybatis.memoryMapper.memoryBoardWrite", memoryDTO);
		return result;
	}
	
	//select : 목록 List 불러오기
	public List<MemoryDTO> memoryBoardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<MemoryDTO> list = 
						sqlSession.selectList("mybatis.memoryMapper.memoryBoardList" , map);
		
		
		return list;
	}
	
	//select : 내가 올린 글 목록 List 불러오기
	public List<MemoryDTO> memoryBoardMyList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<MemoryDTO> list = 
						sqlSession.selectList("mybatis.memoryMapper.memoryBoardMyList" , map);
		
		return list;
	}
	
	//총 글수 얻기
	public int getTotalMemory() {
		return sqlSession.selectOne("mybatis.memoryMapper.getTotalMemory");
	}

	//내가 쓴 글수 얻기
	public int getMyTotalMemory() {
		return sqlSession.selectOne("mybatis.memoryMapper.getMyTotalMemory");
	}
	
	//select : 글 하나 얻어오기
	public MemoryDTO memoryBoardView(int seq) {
		return sqlSession.selectOne("mybatis.memoryMapper.memoryBoardView", seq);
	}
	
	//update : 조회수 증가시키기
	public int memoryBoardHit(int memory_num) {
		return sqlSession.update("mybatis.memoryMapper.memoryBoardHit", memory_num);
	}
	
	//update : 추천수 증가시키기
	public int memoryBoardRec(int memory_num) {
		return sqlSession.update("mybatis.memoryMapper.memoryBoardRec", memory_num);
	}
	//update : 비추천수 증가시키기
	public int memoryBoardNrec(int memory_num) {
		return sqlSession.update("mybatis.memoryMapper.memoryBoardNrec", memory_num);
	}
	
	//select : 최다 추천수 TOP 3 목록 출력
	public List<MemoryDTO> memoryRankingTopThree() {
		List<MemoryDTO> list = null;
		list = sqlSession.selectList("mybatis.memoryMapper.memoryRankingTopThree");
		return list;
	}
}
