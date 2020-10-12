package memory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class MemoryListController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memoryList")
	public ModelAndView memoryList(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			if(!request.getParameter("pg").equals("")) {
				pg = Integer.parseInt(request.getParameter("pg"));
			}
		}
		
		int endNum = pg * 8 ;
		
		int startNum = endNum - 7 ;
		
		int totalNum = ourMemoryService.getTotalMemory();

		int startPage = (pg - 1) / 5 * 5 + 1;

		int endPage = startPage + 4;

		int maxPage = (totalNum - 4) / 5;

		if (endPage > maxPage)
			endPage = maxPage;
		
		List<MemoryDTO> list = ourMemoryService.memoryBoardList(startNum, endNum);
		
		modelAndView.addObject("pg" , pg);
		modelAndView.addObject("endPage" , endPage);
		modelAndView.addObject("startPage" , startPage);
		modelAndView.addObject("maxPage" , maxPage);
		modelAndView.addObject("list", list);
		
		modelAndView.setViewName("index.jsp?req=memoryList");
		
		return modelAndView;
	}
	
}
