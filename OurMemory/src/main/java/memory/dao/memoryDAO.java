package memory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import memory.dto.memoryDTO;


public class memoryDAO {
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="javaexam";
	String password = "l1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 1. driver 라이브러리가 등록되어있는지 확인
	public memoryDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. 커넥션 객체 얻기
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 3. 커넥션 객체 닫기
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 저장 : insert
	public int boardWrite(memoryDTO memoryDTO) {
		int su = 0;
		String sql = " insert into mymemoryalbum values " + 
					 " (seq_memory_num.nextval, ?, ?, ?, ?, ?, sysdate); ";
	    try {
	       conn = getConnection();
	       pstmt = conn.prepareStatement(sql);              
	       //pstmt.setString(1, boardDTO.getId());
	       //pstmt.setString(2, boardDTO.getName());
	       //pstmt.setString(3, boardDTO.getSubject());
	       //pstmt.setString(4, boardDTO.getContent());
	      
	       su = pstmt.executeUpdate();
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return su;
	}
}
