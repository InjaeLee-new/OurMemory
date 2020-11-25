package android.memory.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
	//l 찾았다 zzzzㅋㅋㅋ걍 복붙해놨었네 맞다
	@RequestMapping(value = "/writeAndroid")
	public void memoryWrite(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		String dir = "D:\\android_Kim_Seungwon\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OurMemory1107\\storage";

		String filePath = "C:\\Users\\USER\\git\\repository\\OurMemory\\src\\main\\webapp\\img";
		MultipartFile img = request.getFile(("memory_file"));
		System.out.println("img : "+img);
//		
//		String fileName = img.getOriginalFilename();
//		
//		File file = new File(dir, fileName);
		String originname = img.getOriginalFilename();
		UUID uuid = UUID.randomUUID(); // 랜덤 글 생성
		String filename = uuid+originname; //파일이름 중복방지
		int lastIndex = originname.lastIndexOf("."); // 오른쪽에서 왼쪽으로 가면서 마지막 글을 찾는 것
		String filetype = originname.substring(lastIndex +1);
		img.transferTo(new File(dir+filename)); //파일로 저장하기
		
		// 파일 복사
		// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.gg
//		try {
//			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
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
		memoryDto.setMemory_file(originname);
		System.out.println("originname : "+originname);
		
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
