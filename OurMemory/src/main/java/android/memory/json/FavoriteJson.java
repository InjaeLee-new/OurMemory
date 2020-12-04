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
import recommand.dto.RecommandDTO;

@Controller
public class FavoriteJson {
  @Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/favoriteJson")
	public void myListJson(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		List<RecommandDTO> list = ourMemoryService.getRecList(id);
		
		String rt = null;
		if(list != null) {
		   
		   rt = "OK";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
		   json.put("total", list.size());
		   
		   JSONArray memoryList = new JSONArray();
		   
		   for(int i = 0 ; i < list.size() ; i++) {
			    JSONObject select = new JSONObject();
		        // 12가지 항목 중 비밀번호 빼고 모두!
			    select.put("recommand_id", list.get(i).getRecommand_id());
		        select.put("recommand_seq", list.get(i).getRecommand_seq());
		        
		        memoryList.add(select);
		   }
		   
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
