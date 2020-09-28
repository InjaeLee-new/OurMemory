package memory.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import memory.dto.memoryDTO;

@Controller
public class MemoryWriteController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memoryWrite")
	public ModelAndView memoryWrite(HttpServletRequest request, HttpServletResponse response, MultipartFile img) throws Exception {
		String filePath = "C:\\Users\\USER\\git\\repository\\OurMemory\\src\\main\\webapp\\img";
		
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		
		// 파일 복사
		// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		memoryDTO memoryDto = new memoryDTO();
		memoryDto.setMemory_name(request.getParameter("memory_name"));
		memoryDto.setMemory_pass(request.getParameter("memory_pass"));
		memoryDto.setMemory_subject(request.getParameter("memory_subject"));
		memoryDto.setMemory_content(request.getParameter("memory_content"));
		memoryDto.setMemory_file(fileName);
		
		int result = ourMemoryService.memoryBoardWrite(memoryDto);
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=writeMemoryPro");
		
		return modelAndView;
	}

}
