package contact.Controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContactController {
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		
		modelAndView.setViewName("index.jsp?req=contact");
		
		
		return modelAndView;
	}
}
