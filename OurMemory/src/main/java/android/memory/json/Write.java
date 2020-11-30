package android.memory.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class Write {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/writeAndroid")
	public void memoryWrite(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 승원 집 컴퓨터 경로
		String dir = "D:\\android_Kim_Seungwon\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OurMemory1107\\storage\\";

		String filePath = "C:\\Users\\USER\\git\\repository\\OurMemory\\src\\main\\webapp\\img";
		// 파일 여러개 올리게 리스트 형식으로 생성 
		MultipartFile img1 = request.getFile("memory_file1");
		MultipartFile img2 = request.getFile("memory_file2");
		MultipartFile img3 = request.getFile("memory_file3");
		MultipartFile img4 = request.getFile("memory_file4");
		MultipartFile img5 = request.getFile("memory_file5");
		System.out.println("img : "+img1);
		
		String arrayFileName = "";
		String originname1 = "";
		if (img1 != null) {
			originname1 = img1.getOriginalFilename();
			img1.transferTo(new File(dir+originname1)); //파일로 저장하기	
			if (img2 != null) {
				String originname2 = img2.getOriginalFilename();
				img2.transferTo(new File(dir+originname2)); //파일로 저장하기
				arrayFileName += ", "+originname2;
				if (img3 != null) {
					String originname3 = img3.getOriginalFilename();
					img3.transferTo(new File(dir+originname3)); //파일로 저장하기
					arrayFileName += ", "+originname3;
					if (img4 != null) {
						String originname4 = img4.getOriginalFilename();
						img4.transferTo(new File(dir+originname4)); //파일로 저장하기
						arrayFileName += ", "+originname4;
						if (img2 != null) {
							String originname5 = img5.getOriginalFilename();
							img5.transferTo(new File(dir+originname5)); //파일로 저장하기	
							arrayFileName += ", "+originname5;
						}
					}
				}
			}
		}
		
		MemoryDTO memoryDto = new MemoryDTO();
		memoryDto.setMemory_name(request.getParameter("memory_name"));
		System.out.println("memory_name : "+request.getParameter("memory_name"));
		memoryDto.setMemory_pass(request.getParameter("memory_pass"));
		System.out.println("memory_pass : "+request.getParameter("memory_pass"));
		memoryDto.setMemory_id(request.getParameter("memory_id"));
		System.out.println("memory_id : "+request.getParameter("memory_id"));
		memoryDto.setMemory_subject(request.getParameter("memory_subject"));
		System.out.println("memory_subject : "+request.getParameter("memory_subject"));
		memoryDto.setMemory_content(request.getParameter("memory_content"));
		System.out.println("memory_content : "+request.getParameter("memory_content"));
		memoryDto.setMemory_category(request.getParameter("memory_category"));
		System.out.println("memory_category : "+request.getParameter("memory_category"));
		memoryDto.setMemory_file(originname1 + arrayFileName);
		System.out.println("arrayFileName : "+ originname1+ arrayFileName);
		
		int result = ourMemoryService.writeAndroid(memoryDto);
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
