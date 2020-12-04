package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import member.dto.MemberDTO;

@Controller
public class MemberLoginController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id(request.getParameter("id"));
		memberDTO.setPwd(request.getParameter("pw"));
		
		int result = ourMemoryService.memberLogin(memberDTO.getUser_id(), memberDTO.getPwd());
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=loginPro");
		
		// servlet에서 session 관리를 위해 선언
		HttpSession session = request.getSession();
		if(result > 0) {
			MemberDTO memberDTOInfo = ourMemoryService.memberInformation(request.getParameter("id"));
			session.setAttribute("isLogin", "login!");
			session.setAttribute("id", memberDTOInfo.getUser_id());
			session.setAttribute("name", memberDTOInfo.getUser_name());
			session.setAttribute("nickname", memberDTOInfo.getNickname());
			session.setAttribute("dto", memberDTOInfo);
			System.out.println("MemberLoginController에서 나온 시스템 메세지");
			System.out.println("넘어온 id 값은? = " + request.getParameter("id"));
			System.out.println("id = " + memberDTOInfo.getUser_id());
			System.out.println("pw = " + memberDTOInfo.getPwd());
			System.out.println("name = " + memberDTOInfo.getUser_name());
			System.out.println("nickname = " + memberDTOInfo.getNickname());
		} else {
			session.setAttribute("isLogin", null);
		}
		
		return modelAndView;
	}
}
