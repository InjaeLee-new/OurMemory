package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;

@Controller
public class RecommandController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	// Android에서 추천에 관한 Controller
	@RequestMapping(value = "/recommendation")
	public void recommendation
	(HttpServletRequest request, HttpServletResponse response) {
	
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		
		int result = ourMemoryService.memoryBoardRec(memory_num);
		String rt = "Fail";
	    if(result > 0) rt = "OK";
		
		JSONObject json = new JSONObject();
		json.put("rt",rt);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Android에서 비추천에 관한 Controller
	@RequestMapping(value = "/notrecommendation")
	public void	notrecommendation
	(HttpServletRequest request, HttpServletResponse response) {
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		
		int result = ourMemoryService.memoryBoardNrec(memory_num);
		
		String rt = "Fail";
	    if(result > 0) rt = "OK";
		
		JSONObject json = new JSONObject();
		json.put("rt",rt);
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
