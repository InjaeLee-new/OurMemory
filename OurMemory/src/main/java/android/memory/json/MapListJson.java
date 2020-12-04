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
import map.dto.MapDTO;
import memory.dto.MemoryDTO;

@Controller
public class MapListJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/mapListJson")
	public void mapList(HttpServletRequest request, HttpServletResponse response) {
		
		MapDTO mapDTO = new MapDTO();
		
		List<MapDTO> list = ourMemoryService.mapList(mapDTO);
		
		String rt = null;
		if(list != null) {
		   
		   rt = "OK";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
		   json.put("total", list.size());
		   
		   JSONArray mapList = new JSONArray();
		   
		   for(int i = 0 ; i < list.size() ; i++) {
			    JSONObject select = new JSONObject();
		        select.put("address", list.get(i).getAddress());
		        mapList.add(select);
		   }
		   json.put("mapList", mapList);
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
