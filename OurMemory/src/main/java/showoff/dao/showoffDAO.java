package showoff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	//총 글수 얻기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.showoffMapper.getTotalA");
	}
}
