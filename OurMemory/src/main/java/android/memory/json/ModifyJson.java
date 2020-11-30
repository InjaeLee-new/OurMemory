package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class ModifyJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/modifyJson")
	public void memoryModifyJson(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		
		int result = 0;
		String rt = null;
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		String memory_subject = request.getParameter("memory_subject");
		String memory_content = request.getParameter("memory_content");
		String memory_category = request.getParameter("memory_category");
		
		MemoryDTO dto = new MemoryDTO();
		
		dto.setMemory_num(memory_num);
		dto.setMemory_subject(memory_subject);
		dto.setMemory_content(memory_content);
		dto.setMemory_category(memory_category);
		
		result = ourMemoryService.memoryModify(dto);
		System.out.println("수정 한 후의 result = " + result);
		if(result > 0) {
			rt = "성공!";
			JSONObject json = new JSONObject();
			json.put("rt", rt);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
