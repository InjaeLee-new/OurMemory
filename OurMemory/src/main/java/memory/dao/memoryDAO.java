package memory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
