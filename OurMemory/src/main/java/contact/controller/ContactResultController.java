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
public class ContactResultController {
	
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/contactResult")
	public ModelAndView contactInsert (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String email01 = request.getParameter("email01");
		String email02 = request.getParameter("email02");
		String mPhone1 = request.getParameter("mPhone1");
		String mPhone2 = request.getParameter("mPhone2");
		String mPhone3 = request.getParameter("mPhone3");
		String reason = request.getParameter("reason");
		String callBack = request.getParameter("callBack");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		ContactDTO dto = new ContactDTO();
		dto.setContact_name(userName);
		dto.setContact_id(userId);
		dto.setContact_pwd(userPw);
		dto.setContact_email1(email01);
		dto.setContact_email2(email02);
		dto.setContact_tel1(mPhone1);
		dto.setContact_tel2(mPhone2);
		dto.setContact_tel3(mPhone3);
		dto.setContact_reason(reason);
		dto.setContact_callback(callBack);
		dto.setContact_subject(subject);
		dto.setContact_content(message);
		
		int result = ourMemoryService.contactInsert(dto);
		
		// 화면 전환
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("index.jsp?req=contactPro");
		
		return modelAndView;
		
	}
	
}
