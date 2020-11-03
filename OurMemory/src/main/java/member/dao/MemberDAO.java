package member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.dto.MemberDTO;

@Repository
public class MemberDAO {
	//
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int memberJoin(MemberDTO memberDTO) {
		int result = sqlSession.insert("mybatis.memberMapper.memberJoin", memberDTO);
		return 0;
	}
	
	public int memberLogin(String id) {
		MemberDTO memberDTO = sqlSession.selectOne("mybatis.memberMapper.memberLogin", id);
		int result = 0;
		if(!memberDTO.getName().equals("")) {
			result = 1;
		}
		
		return result;
	}
}
