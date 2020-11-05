package memory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import showoff.dto.ShowoffDTO;

@Controller
public class ShowOffMyViewController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/showoffMyView")
	public ModelAndView showoffView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		ourMemoryService.showoffBoardHit(board_num);
		
		ShowoffDTO dto = ourMemoryService.showoffBoardView(board_num);
		
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("pg", pg);
		
		
		
		modelAndView.setViewName("index.jsp?req=showoffMyView");
		
		return modelAndView;
	}
}
