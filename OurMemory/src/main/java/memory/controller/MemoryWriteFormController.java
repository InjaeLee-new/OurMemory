package memory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemoryWriteFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = 0;
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.jsp?req=writeMemory");
		
		return modelAndView;
	}

}
