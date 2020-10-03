package OurMemory.service;


import java.util.List;

import memory.dto.memoryDTO;
import showoff.dto.showoffDTO;

public interface OurMemoryService {
	
	//memoryBoardWrite : 추억 저장소 글 저장
	public int memoryBoardWrite(memoryDTO memoryDTO);
	
	//memoryBoardList : N개씩 목록 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<memoryDTO> memoryBoardList(int startNum, int endNum);
	
	//memory의 총 글 수 가져오기
	public int getTotalMemory();
	
	//select : 글 하나 얻어오기
	public memoryDTO memoryBoardView(int seq);
	
	//showoffBoardWrite : 반려동물 자랑하기 글 저장
	public int showoffBoardWrite(showoffDTO showoffDTO);
	
	//showoffBoardList : N개씩 목록을 끊어오는 함수 (우리가 startNum,endNum을 설정할 때마다 바뀐다.)
	public List<showoffDTO> showoffBoardList(int startNum, int endNum);
	
	//showoff의 총 글 수 가져오기
	public int getTotalShowoff();
	
	//select : 글 하나 얻어오기
	public showoffDTO showoffBoardView(int seq);
	
}
