package memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import memory.dao.memoryDAO;
import memory.dto.memoryDTO;

@Service
public class OurMemoryServiceImpl implements OurMemoryService {
	@Autowired // autowired는 setter를 통해서 bean 객체를 자동 주입할 수 있다.
	private memoryDAO memoryDAO;

	@Override
	public int memoryBoardWrite(memoryDTO memoryDTO) {
		return memoryDAO.memoryBoardWrite(memoryDTO);
	}

	@Override
	public List<memoryDTO> memoryBoardList(int startNum, int endNum) {
		return memoryDAO.memoryBoardList(startNum, endNum);
	}

	
}
