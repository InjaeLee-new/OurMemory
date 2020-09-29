package memory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import memory.dto.memoryDTO;

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
		
		int endNum = pg * 10 ;
		
		int startNum = endNum - 9 ;
		
		int test;
		
		List<memoryDTO> list = ourMemoryService.memoryBoardList(startNum, endNum);
		
		modelAndView.addObject("list", list);
		
		modelAndView.setViewName("index.jsp?req=memoryList");
		
		return modelAndView;
	}
	
}
