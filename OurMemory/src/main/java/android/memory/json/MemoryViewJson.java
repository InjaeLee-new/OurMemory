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
import memory.dto.MemoryDTO;

@Controller
public class MemoryViewJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/memoryViewJson")
	public void listJson(HttpServletRequest request, HttpServletResponse response) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MemoryDTO memoryDTO = ourMemoryService.memoryBoardView(seq);
		
		String rt = null;
		if(memoryDTO != null) {
		   
		   rt = "OK";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
//		   json.put("total", list.size());
		   
  	       JSONArray memoryView = new JSONArray();
		   
		   
			   
			    JSONObject select = new JSONObject();
		        select.put("memory_num", seq);
		        select.put("memory_file", memoryDTO.getMemory_file());
		        select.put("memory_subject", memoryDTO.getMemory_subject());
		        select.put("memory_content", memoryDTO.getMemory_content());
		        select.put("memory_date", memoryDTO.getMemory_date());
		        select.put("memory_rec", memoryDTO.getMemory_rec());
		        select.put("memory_hit", memoryDTO.getMemory_hit());
		        select.put("memory_nrec", memoryDTO.getMemory_nrec());
		        select.put("memory_name", memoryDTO.getMemory_name());
		        select.put("memory_category", memoryDTO.getMemory_category());
		        
		        
		        memoryView.add(select);
		   
		   
		   json.put("memoryView", memoryView);
		   
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
