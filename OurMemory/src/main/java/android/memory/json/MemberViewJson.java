package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import member.dto.MemberDTO;
import memory.dto.MemoryDTO;

@Controller
public class MemberViewJson {

	@Autowired
	OurMemoryService ourMemoryService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/memberViewJson")
	public void listJson(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		MemberDTO memberDTO = ourMemoryService.memberInformation(id);
		
		String rt = null;
		if(memberDTO != null) {
		   
		   rt = "OK";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
//		   json.put("total", list.size());
		   
  	       JSONArray memberView = new JSONArray();

			    JSONObject select = new JSONObject();
		        select.put("user_name", memberDTO.getUser_name());
		        select.put("user_id", memberDTO.getUser_id());
		        select.put("pwd", memberDTO.getPwd());
		        select.put("nickname", memberDTO.getNickname());
		        select.put("gender", memberDTO.getGender());
		        select.put("email1", memberDTO.getEmail1());
		        select.put("email2", memberDTO.getEmail2());
		        select.put("tel1", memberDTO.getTel1());
		        select.put("tel2", memberDTO.getTel2());
		        select.put("tel3", memberDTO.getTel3());
		        select.put("addr", memberDTO.getAddr());
		        select.put("profile_image", memberDTO.getProfile_image());
		        select.put("logtime", memberDTO.getLogtime());
		        
		        memberView.add(select);
		   
		   
		   json.put("memberView", memberView);
		   
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}
	}
}
