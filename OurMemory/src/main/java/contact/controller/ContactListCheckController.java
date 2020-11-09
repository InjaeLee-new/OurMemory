package contact.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;


@Controller
public class ContactListCheckController {
	
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/contactListCheck")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("userPw", userPw);
		modelAndView.setViewName("index.jsp?req=contactListCheck");
		
		return modelAndView;
	}
}
