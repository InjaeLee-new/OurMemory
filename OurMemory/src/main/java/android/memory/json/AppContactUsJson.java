package android.memory.json;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import OurMemory.service.OurMemoryService;
import contact.dto.AppContactDTO;

@Controller
public class AppContactUsJson {
	
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/contactUsAndroid")
	public void contactUsWrite(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		// 승원 집 컴퓨터 경로
		String dir = "D:\\android_Kim_Seungwon\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OurMemory1107\\storage\\";
		// 인제 컴퓨터 경로
//		String filePath = "C:\\Users\\USER\\git\\ourMemoryWeb\\OurMemory\\src\\main\\webapp\\img";
		
		MultipartFile img = request.getFile("contact_file");
		String originname ="X";
		if (img != null) {
			originname = img.getOriginalFilename();
			File file = new File(dir + originname);
			img.transferTo(file); //파일로 저장하기	
		}
		
		
		AppContactDTO appContactDTO = new AppContactDTO();
		appContactDTO.setContact_id(request.getParameter("contact_id"));
		appContactDTO.setContact_name(request.getParameter("contact_name"));
		appContactDTO.setContact_subject(request.getParameter("contact_subject"));
		appContactDTO.setContact_content(request.getParameter("contact_content"));
		appContactDTO.setContact_callback(request.getParameter("contact_callback"));
		// 안드로이드에서 tel, email 중 선택해서 값을 보냄 ( 값이 null은 아님 )
		appContactDTO.setContact_tel(request.getParameter("contact_tel"));		
		appContactDTO.setContact_email(request.getParameter("contact_email"));			
		appContactDTO.setContact_file(originname);
		
		
		int result = ourMemoryService.appContactInsert(appContactDTO);
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
