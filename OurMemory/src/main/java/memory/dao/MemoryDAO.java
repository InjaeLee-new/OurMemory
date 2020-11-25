package memory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import memory.dto.MemoryCommentDTO;
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
	
	//insert : 안드로이드에서 글저장
	public int writeAndroid(MemoryDTO memoryDTO) {
		int result = sqlSession.insert("mybatis.memoryMapper.writeAndroid", memoryDTO);
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
	public List<MemoryDTO> memoryBoardMyList(int startNum, int endNum, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("id", id);
		List<MemoryDTO> list = 
						sqlSession.selectList("mybatis.memoryMapper.memoryBoardMyList" , map);
		
		return list;
	}
	
	//총 글수 얻기
	public int getTotalMemory() {
		return sqlSession.selectOne("mybatis.memoryMapper.getTotalMemory");
	}

	//내가 쓴 글수 얻기
	public int getMyTotalMemory(String id) {
		return sqlSession.selectOne("mybatis.memoryMapper.getMyTotalMemory", id);
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
	
	//insert : 추천 / 비추천 안 했을 시 넣는다.
	public int recommandInsert(RecommandDTO dto) {
		int result = sqlSession.insert("mybatis.memoryMapper.recommandInsert", dto);
		return result;
	}
	
	//select : 추천 유무
	public int recommandCheck(int recommand_seq, String recommand_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recommand_seq", recommand_seq);
		map.put("recommand_id", recommand_id);
		return sqlSession.selectOne("mybatis.memoryMapper.recommandCheck", map);
	}
	
	//select : 내가 올린 글 목록 List 불러오기
	public List<MemoryDTO> memoryBoardHealthList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<MemoryDTO> list = 
			  sqlSession.selectList("mybatis.memoryMapper.memoryBoardHealthList" , map);

		return list;
	}
	
	//select : 내가 올린 글 목록 List 불러오기
	public List<MemoryDTO> memoryBoardArtList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<MemoryDTO> list = sqlSession.selectList("mybatis.memoryMapper.memoryBoardArtList" , map);
		
		return list;
	}
	   
	//select : category 선택 글 목록 List 불러오기
	public List<MemoryDTO> totalList(int startNum, int endNum, 
		  String cate1, String cate2, String cate3) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("cate1", cate1);
		map.put("cate2", cate2);
		map.put("cate3", cate3);

		List<MemoryDTO> list = 
			  sqlSession.selectList("mybatis.memoryMapper.totalList" , map);

		return list;
	}
	   
	 //health 글수 얻기
	public int getHealthTotalMemory() {
	     	return sqlSession.selectOne("mybatis.memoryMapper.getHealthTotalMemory");
	}
	
	
	//select : 최다 추천수 TOP 3 목록 출력
	public List<MemoryDTO> memoryRankingTopThree() {
		List<MemoryDTO> list = null;
		list = sqlSession.selectList("mybatis.memoryMapper.memoryRankingTopThree");
		return list;
	}
	//카테고리 총글수 얻기
	public List<MemoryDTO> getcategoryMemory(String memory_category) {
		return sqlSession.selectList("mybatis.memoryMapper.getcategoryMemory", memory_category);
	}
	
	// 여기부턴 댓글에 관한 내용을 담는 곳입니다. 필요한 내용을 추가해주세요.
	public List<MemoryCommentDTO> commentViewJson(int seq) {
		return sqlSession.selectList("mybatis.memoryMapper.commentViewJson", seq);
	}
	
	// 댓글작성 후 database에 저장한다
	public int commentWriteJson(int memory_seq, String memory_comment_name, String memory_comment_content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memory_seq", memory_seq);
		map.put("memory_comment_name", memory_comment_name);
		map.put("memory_comment_content", memory_comment_content);
		return sqlSession.insert("mybatis.memoryMapper.commentWriteJson", map);
	}
}
