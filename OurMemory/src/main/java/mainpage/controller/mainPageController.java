package mainpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;
import showoff.dto.ShowoffDTO;

@Controller
public class mainPageController {
	
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping
	public ModelAndView mainPageView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ShowoffDTO> topshowList = ourMemoryService
				.showoffRankingTopThree();
		
		List<MemoryDTO> topmemoryList = ourMemoryService
				.memoryRankingTopThree();
		
		System.out.println(topshowList.size());
		System.out.println(topmemoryList.size());
		
		modelAndView.addObject("topshowList", topshowList);
		modelAndView.addObject("topmemoryList", topmemoryList );
		
		modelAndView.setViewName("index.jsp");
		
		return modelAndView;
	}

}
