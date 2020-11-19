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
import memory.dto.MemoryCommentDTO;

@Controller
public class ViewCommentWriteJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/viewCommentWriteJson")
	public void memoryViewJson(HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int memory_seq = Integer.parseInt(request.getParameter("memory_seq"));
		String memory_comment_name = request.getParameter("memory_comment_name");
		String memory_comment_content = request.getParameter("memory_comment_content");
		
		int result = ourMemoryService.commentWriteJson(memory_seq, memory_comment_name, memory_comment_content);
		String rt = null;
		
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