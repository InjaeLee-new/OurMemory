package memory.controller;


import java.util.List;

import memory.dto.memoryDTO;

public interface OurMemoryService {
	
	//memoryBoardWrite : 추억 저장소 글저장
	public int memoryBoardWrite(memoryDTO memoryDTO);
	
	//memoryBoardList : N개씩 목록 끊어오는 함수
	public List<memoryDTO> memoryBoardList(int startNum, int endNum);
}
