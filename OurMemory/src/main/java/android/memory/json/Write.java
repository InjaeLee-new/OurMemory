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
		// 파일 여러개 올리게 리스트 형식으로 작성				files 's' 확인
		List<MultipartFile> imgList = request.getFiles("memory_file");
		System.out.println("img : "+imgList);
//		
//		String fileName = img.getOriginalFilename();
//		
//		File file = new File(dir, fileName);
		String arrayFileName="";
		
		for (int i = 0; i< imgList.size(); i++) {
			MultipartFile mf = imgList.get(i);
			String originname = mf.getOriginalFilename();
//			일단 주석처리 한 곳은 파일 이름 동일시 안되게 하려고 한것임
//			UUID uuid = UUID.randomUUID(); // 랜덤 글 생성  
//			String filename = uuid+originname; //파일이름 중복방지
			int lastIndex = originname.lastIndexOf("."); // 온전히 파일 이름만 저장
			String filetype = originname.substring(lastIndex +1); // 파일타입 구분 (jpg, png, gif)
			mf.transferTo(new File(dir+originname)); //파일로 저장하기
			if (i==imgList.size()-1) {
				arrayFileName += originname;
			}else {
				arrayFileName += originname+", ";				
			}
		}
		
		
		MemoryDTO memoryDto = new MemoryDTO();
		
		System.out.println("memory_name : "+request.getParameter("memory_name"));
		System.out.println("memory_pass : "+request.getParameter("memory_pass"));
		System.out.println("memory_id : "+request.getParameter("memory_id"));
		System.out.println("memory_subject : "+request.getParameter("memory_subject"));
		System.out.println("memory_content : "+request.getParameter("memory_content"));
		System.out.println("memory_category : "+request.getParameter("memory_category"));
		System.out.println("originname : "+arrayFileName);
		
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
