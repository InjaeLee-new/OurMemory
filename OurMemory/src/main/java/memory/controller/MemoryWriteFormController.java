package memory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemoryWriteFormController  {
	
	@RequestMapping(value = "/memoryWriteForm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = 0;
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.jsp?req=writeMemory");
		
		return modelAndView;
	}
}
