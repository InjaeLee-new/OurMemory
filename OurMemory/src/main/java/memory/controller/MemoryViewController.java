package memory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.memoryDTO;

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
		
		memoryDTO dto = ourMemoryService.memoryBoardView(memory_num);
		
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("pg", pg);
		
		
		
		modelAndView.setViewName("index.jsp?req=memoryView");

		
		return modelAndView;
	}
}
