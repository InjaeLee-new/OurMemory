package showoff.controller;

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

import OurMemory.service.OurMemoryService;
import showoff.dto.showoffDTO;

@Controller
public class ShowOffWriteController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/showoffWrite")
	public ModelAndView showoffWrite(HttpServletRequest request, HttpServletResponse response, MultipartFile img) throws Exception {
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
		
		showoffDTO showoffDto = new showoffDTO();
		showoffDto.setBoard_name(request.getParameter("board_name"));
		showoffDto.setBoard_pass(request.getParameter("board_pass"));
		showoffDto.setBoard_subject(request.getParameter("board_subject"));
		showoffDto.setBoard_content(request.getParameter("board_content"));
		showoffDto.setBoard_file(fileName);
		
		//int result = ourMemoryService.memoryBoardWrite(memoryDto);
		
		//modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=writeShowOffPro");
		
		return modelAndView;
	}
}
