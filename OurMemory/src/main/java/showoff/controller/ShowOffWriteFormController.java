package showoff.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowOffWriteFormController {
	
	@RequestMapping(value = "/showoffWriteForm")
	public ModelAndView showOffWriteForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.jsp?req=writeShowOff");
		
		return modelAndView;
	}
}
