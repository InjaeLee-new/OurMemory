package mainpage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;

@Controller
public class mainPageController {
	
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping
	public ModelAndView mainPageView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}

}
