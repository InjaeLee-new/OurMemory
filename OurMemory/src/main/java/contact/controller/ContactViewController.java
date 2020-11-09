package contact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import contact.dto.ContactDTO;

@Controller
public class ContactViewController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/contactView")
	public ModelAndView contactInsert (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int contact_num = Integer.parseInt(request.getParameter("contact_num"));
		
		ContactDTO dto = new ContactDTO();
		
		dto = ourMemoryService.contactSelectOne(contact_num);
		
		
		
		
		// 화면 전환
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("index.jsp?req=contactView");
		
		return modelAndView;
		
	}
}
