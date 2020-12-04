package android.memory.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import OurMemory.service.OurMemoryService;
import appmember.dto.AppMemberDTO;
import map.dto.MapDTO;
import member.dto.MemberDTO;

@Controller
public class MapInsertJson {
	
	@Autowired 
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/MapInsertJson")
	public void mapInsertJson(HttpServletRequest request, HttpServletResponse response, MultipartFile profile) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String address = request.getParameter("address");
		
		MapDTO mapDTO = new MapDTO();
	
		mapDTO.setAddress(address);
		
		int result1 = ourMemoryService.mapInsert(mapDTO);
		
		String rt = null;
		
		if(result1 != 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
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
