package memory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryCommentDTO;
import memory.dto.MemoryDTO;

@Controller
public class MemoryViewController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memoryView")
	public ModelAndView memoryView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		ourMemoryService.memoryBoardHit(memory_num);
		
		MemoryDTO dto = ourMemoryService.memoryBoardView(memory_num);
		List<MemoryCommentDTO> list = ourMemoryService.commentViewJson(memory_num);
		
		String[] splitFileName = dto.getMemory_file().split(", ");
		dto.setMemory_file(splitFileName[0]);
		
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		
		
		
		modelAndView.setViewName("index.jsp?req=memoryView");

		
		return modelAndView;
	}
}
