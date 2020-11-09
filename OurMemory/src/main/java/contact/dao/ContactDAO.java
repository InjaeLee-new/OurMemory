package contact.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import contact.dto.ContactDTO;


@Repository
public class ContactDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//insert : 글저장
	public int contactInsert(ContactDTO contactDTO) {
		int result = sqlSession.insert("mybatis.contactMapper.contactInsert", contactDTO);
		return result;
	}
		
	//select : 목록 List 불러오기
	public List<ContactDTO> contactSelectAll(String contact_id) {
		List<ContactDTO> list = sqlSession.selectList("mybatis.contactMapper.contactSelectAll" , contact_id);
			
			return list;
		}	
	


	//select : 해당 글 불러오기 (선택한 1개만)
	public ContactDTO contactSelectOne(int contact_num) {
		return	sqlSession.selectOne("mybatis.contactMapper.contactSelectOne" , contact_num);
	}

	// update : 내용 수정하기
	public int contactUpdate(ContactDTO contactDTO) {
		return	sqlSession.update("mybatis.contactMapper.contactUpdate" , contactDTO);
	}
	
	// delete : 글 삭제하기
		public int contactDelete(int contact_num) {
			return	sqlSession.update("mybatis.contactMapper.contactDelete" , contact_num);
		}
		
		//총 글수 얻기
		      public int getTotalContact(String contact_id) {
		         return sqlSession.selectOne("mybatis.contactMapper.getTotalContact");
		      }
		
}






