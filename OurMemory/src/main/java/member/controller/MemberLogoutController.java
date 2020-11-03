package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;

@Controller
public class MemberLogoutController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberLogout")
	public ModelAndView memberLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.jsp");
		
		// servlet에서 session 관리를 위해 선언
		HttpSession session = request.getSession();
		session.setAttribute("isLogin", null);
		
		return modelAndView;
	}
}
