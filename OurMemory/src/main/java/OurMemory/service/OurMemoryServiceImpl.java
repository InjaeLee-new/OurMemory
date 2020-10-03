package OurMemory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import memory.dao.memoryDAO;
import memory.dto.memoryDTO;
import showoff.dao.showoffDAO;
import showoff.dto.showoffDTO;

@Service
public class OurMemoryServiceImpl implements OurMemoryService {
	@Autowired // autowired는 setter를 통해서 bean 객체를 자동 주입할 수 있다.
	private memoryDAO memoryDao;
	
	@Autowired
	private showoffDAO showoffDao;

	@Override
	public int memoryBoardWrite(memoryDTO memoryDTO) {
		return memoryDao.memoryBoardWrite(memoryDTO);
	}

	@Override
	public List<memoryDTO> memoryBoardList(int startNum, int endNum) {
		return memoryDao.memoryBoardList(startNum, endNum);
	}

	@Override
	public int showoffBoardWrite(showoffDTO showoffDTO) {
		return showoffDao.showoffBoardWrite(showoffDTO);
	}

	@Override
	public List<showoffDTO> showoffBoardList(int startNum, int endNum) {
		return showoffDao.showoffBoardList(startNum, endNum);
	}

	@Override
	public int getTotalMemory() {
		return memoryDao.getTotalMemory();
	}
	
	@Override
	public int getTotalShowoff() {
		return showoffDao.getTotalShowoff();
	}

	@Override
	public memoryDTO memoryBoardView(int seq) {
		return memoryDao.memoryBoardView(seq);
	}

	@Override
	public showoffDTO showoffBoardView(int seq) {
		return showoffDao.showoffBoardView(seq);
	}

	
}
