package member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;

public class MemberLoginController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = ourMemoryService.memberLogin(request.getParameter("id"));
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=loginPro");
		
		return modelAndView;
	}
}
