package memory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemoryViewController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	public ModelAndView memoryView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.jsp?req=memory");
		
		return modelAndView;
	}
}
