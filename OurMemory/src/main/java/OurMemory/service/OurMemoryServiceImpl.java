package OurMemory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDAO;
import member.dto.MemberDTO;
import memory.dao.MemoryDAO;
import memory.dto.MemoryDTO;
import showoff.dao.ShowoffDAO;
import showoff.dto.ShowoffDTO;

@Service
public class OurMemoryServiceImpl implements OurMemoryService {
	@Autowired // autowired는 setter를 통해서 bean 객체를 자동 주입할 수 있다.
	private MemoryDAO memoryDao;
	
	@Autowired
	private ShowoffDAO showoffDao;
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	public int memoryBoardWrite(MemoryDTO memoryDTO) {
		return memoryDao.memoryBoardWrite(memoryDTO);
	}

	@Override
	public List<MemoryDTO> memoryBoardList(int startNum, int endNum) {
		return memoryDao.memoryBoardList(startNum, endNum);
	}

	@Override
	public int showoffBoardWrite(ShowoffDTO showoffDTO) {
		return showoffDao.showoffBoardWrite(showoffDTO);
	}

	@Override
	public List<ShowoffDTO> showoffBoardList(int startNum, int endNum) {
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
	public MemoryDTO memoryBoardView(int seq) {
		return memoryDao.memoryBoardView(seq);
	}

	@Override
	public ShowoffDTO showoffBoardView(int seq) {
		return showoffDao.showoffBoardView(seq);
	}

	@Override
	public int memoryBoardHit(int memory_num) {
		return memoryDao.memoryBoardHit(memory_num);
	}

	@Override
	public int showoffBoardHit(int board_num) {
		return showoffDao.showoffBoardHit(board_num);
	}

	@Override
	public int memoryBoardRec(int memory_num) {
		return memoryDao.memoryBoardRec(memory_num);
	}

	@Override
	public int memoryBoardNrec(int memory_num) {
		return memoryDao.memoryBoardNrec(memory_num);
	}

	@Override
	public int showoffBoardRec(int board_num) {
		return showoffDao.showoffBoardRec(board_num);
	}

	@Override
	public int showoffBoardNrec(int board_num) {
		return showoffDao.showoffBoardNrec(board_num);
	}

	@Override
	public int memberJoin(MemberDTO memberDTO) {
		return memberDao.memberJoin(memberDTO);
	}

	@Override
	public int memberLogin(String id) {
		return memberDao.memberLogin(id);
	}

	@Override
	public List<MemoryDTO> memoryRankingTopThree() {
		return null;
	}

	@Override
	public List<ShowoffDTO> showoffRankingTopThree() {
		return null;
	}

	public boolean isExistedId(String id) {
		return memberDao.isExistedId(id);
	}
}
