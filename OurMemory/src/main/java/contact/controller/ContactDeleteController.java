package contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import contact.dto.ContactDTO;

@Controller
public class ContactDeleteController {
	@Autowired
	   OurMemoryService ourMemoryService;
	   
	   @RequestMapping(value = "/contactDelete")
	   public ModelAndView contactList (HttpServletRequest request) {
	     
	      
	      int contact_num = Integer.parseInt(request.getParameter("contact_num"));
	      
	      int result = ourMemoryService.contactDelete(contact_num);
	     
	      ModelAndView modelAndView = new ModelAndView();
	      modelAndView.addObject("result", result);
	      modelAndView.setViewName("index.jsp?req=contactDelete");
	      
	      return modelAndView;
	   }
	
}
