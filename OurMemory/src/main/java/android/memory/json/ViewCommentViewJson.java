package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryCommentDTO;
import memory.dto.MemoryDTO;

@Controller
public class ViewCommentViewJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/commentViewJson")
	public void listJson(HttpServletRequest request, HttpServletResponse response) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		List<MemoryCommentDTO> list = ourMemoryService.commentViewJson(seq);
		
		String rt = null;
		if(list != null) {
		   
		   rt = "성공!!";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
		   json.put("total", list.size());
		   
		   JSONArray memoryCommentList = new JSONArray();
		   
		   for(int i = 0 ; i < list.size() ; i++) {
			    JSONObject select = new JSONObject();
		        select.put("memory_seq", list.get(i).getMemory_seq());
		        select.put("memory_comment_name", list.get(i).getMemory_comment_name());
		        select.put("memory_comment_content", list.get(i).getMemory_comment_content());
		        select.put("reg_date", list.get(i).getReg_date());
		        
		        memoryCommentList.add(select);
		   }
		   
		   json.put("memoryCommentList", memoryCommentList);
		   
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
