package map.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import contact.dto.ContactDTO;
import map.dto.MapDTO;


@Repository
public class MapDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int mapInsert(MapDTO mapDTO) {
		int result = sqlSession.insert("mybatis.mapMapper.mapInsert", mapDTO);
		return result;
	}
		
	//select : 목록 List 불러오기
	public List<MapDTO> mapList(MapDTO mapDTO) {
		List<MapDTO> list = sqlSession.selectList("mybatis.mapMapper.mapList", mapDTO);
		return list;
	}	
}






