package memory.controller;


import memory.dto.memoryDTO;

public interface OurMemoryService {
	
	//memoryBoardWrite : 추억 저장소 글저장
	public int memoryBoardWrite(memoryDTO memoryDTO);
		
}
