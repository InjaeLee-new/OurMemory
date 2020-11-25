package OurMemory.service;


import java.util.List;

import appmember.dto.AppMemberDTO;
import contact.dto.ContactDTO;
import member.dto.MemberDTO;
import memory.dto.MemoryCommentDTO;
import memory.dto.MemoryDTO;
import showoff.dto.ShowoffDTO;

public interface OurMemoryService {
	
	//memoryBoardWrite : 추억 저장소 글 저장
	public int memoryBoardWrite(MemoryDTO memoryDTO);
	
	//writeAndroid : 안드로이드에서 글 저장
	public int writeAndroid(MemoryDTO memoryDTO);
	
	//memoryBoardList : N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> memoryBoardList(int startNum, int endNum);
	
	//memoryBoardMyList : 내가 올린 게시글 N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> memoryBoardMyList(int startNum, int endNum, String id);
	
	//memoryBoardHealthList : N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> memoryBoardHealthList(int startNum, int endNum);	

	//memoryBoardArtList : N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> memoryBoardArtList(int startNum, int endNum);
	
	//totalList : 선택한 카테고리 별로 가져옴 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> totalList(int startNum, int endNum, 
							String cate1, String cate2, String cate3);	
	
	//memory의 총 글 수 가져오기
	public int getTotalMemory();
	
	//memory의 나의 총 글 수 가져오기
	public int getMyTotalMemory(String id);
	
	//memory의 Health 총 글 수 가져오기
	public int getHealthTotalMemory();	
	
	//select : 글 하나 얻어오기
	public MemoryDTO memoryBoardView(int seq);
	
	//update : 조회수 증가시키기
	public int memoryBoardHit(int memory_num);
	
	//select : 최다 추천수 TOP 3 목록 출력
	public List<MemoryDTO> memoryRankingTopThree();
	
	//select : 해당 글번호를 받아와서 댓글을 출력한다.
	public List<MemoryCommentDTO> commentViewJson(int seq);
	
	//memoryBoardHealthList : N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> memoryBoardHealthList(int startNum, int endNum);	
	
	//totalList : 선택한 카테고리 별로 가져옴 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<MemoryDTO> totalList(int startNum, int endNum, 
							String cate1, String cate2, String cate3);	
	
	//insert : 작성된 댓글을 database에 저장한다.
	public int commentWriteJson(int memory_seq, String memory_comment_name, String memory_comment_content);
	
	///// 여기부턴 showoff 관련 DAO 모음//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//showoffBoardWrite : 반려동물 자랑하기 글 저장
	public int showoffBoardWrite(ShowoffDTO showoffDTO);
	
	//showoffBoardList : N개씩 목록을 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<ShowoffDTO> showoffBoardList(int startNum, int endNum);

	//showoffBoardMyList : 내가 올린 게시글 N개씩 목록을 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<ShowoffDTO> showoffBoardMyList(int startNum, int endNum, String id);
	
	//showoff의 총 글 수 가져오기
	public int getTotalShowoff();

	//showoff의 내가 쓴 글 수 가져오기
	public int getMyTotalShowoff(String id);
	
	//select : 글 하나 얻어오기
	public ShowoffDTO showoffBoardView(int seq);
	
	//update : 조회수 증가시키기
	public int showoffBoardHit(int memory_num);
	
	//update : 추천수 증가시키기
	public int memoryBoardRec(int memory_num);
	
	//update : 비추천수 증가시키기
	public int memoryBoardNrec(int memory_num);
	
	//update : 추천수 증가시키기
	public int showoffBoardRec(int board_num);
	
	//update : 비추천수 증가시키기
	public int showoffBoardNrec(int board_num);
	
	//insert : 추천 유무 확인
	public int recommandInsert(RecommandDTO recommandDTO);
	
	//select : 추천 유무 확인
	public int recommandCheck(int recommand_seq, String recommand_id);
	
	//select : 최다 추천수 TOP 3 목록 출력
	public List<ShowoffDTO> showoffRankingTopThree();
	
	///// 여기부턴 member 관련 DAO 모음//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//insert : 회원가입
	public int memberJoin(MemberDTO memberDTO);
	
	//select : 로그인 할 때, 아이디 확인
	public int memberLogin(String user_id, String pw);
	
	public boolean isExistedId(String id);
	
	// 닉네임과 이름 가져오기 함수 ( 로그인 성공시 )
	public MemberDTO memberInformation(String id);
	
	///////////////////insert : 앱 회원가입
	public int appMemberJoin (AppMemberDTO appMemberDTO);
	
	///// 여기부턴 contact 관련 DAO 모음//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//insert : 글저장
	   public int contactInsert(ContactDTO contactDTO) ;
	      
	   //select : 목록 List 불러오기
	   public List<ContactDTO> contactSelectAll(String contact_id);
	   
	   //select : 해당 글 불러오기 (선택한 1개만)
	   public ContactDTO contactSelectOne(int contact_num);

	   // update : 내용 수정하기
	   public int contactUpdate(ContactDTO contactDTO);
	   
	   // delete : 글 삭제하기
	   public int contactDelete(int contact_num);
	   
	   //내가 남긴 글의 총 글 수 가져오기
	   public int getTotalContact(String contact_id);
	
	   // 카테고리별 전체글 불러오기
	   public List<MemoryDTO> membercategory(String memory_category);
}
