package showoff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import showoff.dto.showoffDTO;

@Repository
public class showoffDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int showoffBoardWrite(showoffDTO showoffDTO) {
		int result = sqlSession.insert("mybatis.showoffMapper.showoffBoardWrite", showoffDTO);
		return result;
	}
	
	//select : 목록 List 불러오기
	public List<showoffDTO> showoffBoardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<showoffDTO> list = 
						sqlSession.selectList("mybatis.showoffMapper.showoffBoardList" , map);
		
		
		return list;
	}
	
	//select : 총 글수 얻기
	public int getTotalShowoff() {
		return sqlSession.selectOne("mybatis.showoffMapper.getTotalShowoff");
	}
	
	//select : 글 하나 얻어오기
	public showoffDTO showoffBoardView(int seq) {
		return sqlSession.selectOne("mybatis.showoffMapper.showoffBoardView", seq);
	}
	
	//update : 조회수 증가시키기
	public int showoffBoardHit(int board_num) {
		return sqlSession.update("mybatis.showoffMapper.showoffBoardHit", board_num);
	}
	
	//update : 추천수 증가시키기
	public int showoffBoardRec(int board_num) {
		return sqlSession.update("mybatis.showoffMapper.showoffBoardRec", board_num);
	}
	//update : 비추천수 증가시키기
	public int showoffBoardNrec(int board_num) {
		return sqlSession.update("mybatis.showoffMapper.showoffBoardNrec", board_num);
	}
}
