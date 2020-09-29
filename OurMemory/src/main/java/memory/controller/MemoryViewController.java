package memory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import memory.dto.memoryDTO;

@Controller
public class MemoryViewController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	public ModelAndView memoryView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
}
