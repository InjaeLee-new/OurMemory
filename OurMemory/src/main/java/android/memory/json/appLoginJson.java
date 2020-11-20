package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import member.dto.MemberDTO;

@Controller
public class appLoginJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	// Android에서 추천에 관한 Controller
	@RequestMapping(value = "/appLogin")
	public void recommendation (HttpServletRequest request, HttpServletResponse response) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id(request.getParameter("id"));
		memberDTO.setPwd(request.getParameter("pw"));
		
		int result = ourMemoryService.memberLogin(memberDTO.getUser_id(), memberDTO.getPwd());
		String user_name = "";
		String rt = "FAIL";
		if (result > 0) {
			rt = "OK";
			MemberDTO memberDTOInfo = ourMemoryService.memberInformation(request.getParameter("id"));
			user_name = memberDTOInfo.getUser_name();
		}
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("result", result);
		json.put("user_name", user_name);
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
