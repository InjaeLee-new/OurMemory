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
import memory.dto.MemoryDTO;

@Controller
public class TotalListJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/totalListJson")
	public void totalListJson(HttpServletRequest request, HttpServletResponse response) {
		int startNum = Integer.parseInt(request.getParameter("startNum"));
		int endNum = Integer.parseInt(request.getParameter("endNum"));
		
		String cate1 = request.getParameter("cate1");
		String cate2 = request.getParameter("cate2");
		String cate3 = request.getParameter("cate3");
		
		int totalNum = ourMemoryService.getTotalMemory();
		
		List<MemoryDTO> list = 
				ourMemoryService.totalList(startNum, endNum, cate1, cate2, cate3);
		
		String rt = null;
		if(list != null) {
		   
		   rt = "성공!!";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
		   json.put("total", list.size());
		   
		   JSONArray memoryList = new JSONArray();
		   
		   for(int i = 0 ; i < list.size() ; i++) {
			    JSONObject select = new JSONObject();
		        select.put("memory_num", list.get(i).getMemory_num());
		        select.put("memory_file", list.get(i).getMemory_file());
		        select.put("memory_subject", list.get(i).getMemory_subject());
		        select.put("memory_content", list.get(i).getMemory_content());
		        select.put("memory_date", list.get(i).getMemory_date());
		        select.put("memory_rec", list.get(i).getMemory_rec());
		        select.put("memory_hit", list.get(i).getMemory_hit());
		        select.put("memory_nrec", list.get(i).getMemory_nrec());
		        select.put("memory_name", list.get(i).getMemory_name());
		        select.put("memory_category", list.get(i).getMemory_category());
		        
		        memoryList.add(select);
		   }
		   
		   json.put("totalResult", totalNum);
		   json.put("memoryList", memoryList);
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
