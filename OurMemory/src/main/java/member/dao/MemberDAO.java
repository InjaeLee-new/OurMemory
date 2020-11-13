package member.dao;

import java.util.HashMap;
import java.util.Map;

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
		return result;
	}
	
	public int memberLogin(String user_id, String pw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", user_id);
		map.put("pw", pw);
		System.out.println("멤버 dao에 불러온 id와 pw값은?" + user_id + ", " + pw);
		MemberDTO memberDTO = sqlSession.selectOne("mybatis.memberMapper.memberLogin", map);
//		System.out.println("memberDTO는 정상적으로 불러왔을까? getName을 해보자" + memberDTO.getUser_name());
		int result = 0;
		if(memberDTO != null) {
			if(!memberDTO.getUser_name().equals("")) {
				result = 1;
			}
		}
		
		return result;
	}
	
	public boolean isExistedId(String id) {
		boolean result = true;
		result = sqlSession.selectOne("mybatis.memberMapper.memberCheckId", id);
		
		return result;
	}
	
	public MemberDTO memberInformation(String id) {
		MemberDTO memberDTO = null;
		memberDTO = sqlSession.selectOne("mybatis.memberMapper.memberInformation", id);
		
		return memberDTO;
	}
}
