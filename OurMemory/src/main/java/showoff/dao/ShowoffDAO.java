package showoff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import showoff.dto.ShowoffDTO;

@Repository
public class ShowoffDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int showoffBoardWrite(ShowoffDTO showoffDTO) {
		int result = sqlSession.insert("mybatis.showoffMapper.showoffBoardWrite", showoffDTO);
		return result;
	}
	
	//select : 목록 List 불러오기
	public List<ShowoffDTO> showoffBoardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<ShowoffDTO> list = 
						sqlSession.selectList("mybatis.showoffMapper.showoffBoardList" , map);
		
		
		return list;
	}
	
	//select : 내가 쓴 글 목록 List 불러오기
	public List<ShowoffDTO> showoffBoardMyList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<ShowoffDTO> list = 
						sqlSession.selectList("mybatis.showoffMapper.showoffBoardMyList" , map);
		
		return list;
	}
	
	//select : 총 글수 얻기
	public int getTotalShowoff() {
		return sqlSession.selectOne("mybatis.showoffMapper.getTotalShowoff");
	}
	
	//select : 총 내 글수 얻기
	public int getMyTotalShowoff() {
		return sqlSession.selectOne("mybatis.showoffMapper.getMyTotalShowoff");
	}
	
	//select : 글 하나 얻어오기
	public ShowoffDTO showoffBoardView(int seq) {
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
	
	//select : 최다 추천수 TOP 3 목록 출력
	public List<ShowoffDTO> showoffRankingTopThree() {
		List<ShowoffDTO> list = null;
		list = sqlSession.selectList("mybatis.showoffMapper.showoffRankingTopThree");
		return list;
	}
}
