package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
@Controller
public class MemberCheckIdController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberCheckId")
	public ModelAndView memberCheckId(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("userId");
		
		System.out.println(id);
		
		boolean exist = ourMemoryService.isExistedId(id);// true : id가 있음, 사용불가
														 // false: id가 없음, 사용가능
		//데이터 공유
		modelAndView.addObject("id",id);
		modelAndView.addObject("exist",exist);
		
		return modelAndView;
	}
}
