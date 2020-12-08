package memory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryCommentDTO;
import memory.dto.MemoryDTO;

@Controller
public class MemoryCommentWrite {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/MemoryCommentWrite")
	public ModelAndView memoryViewJson(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int memory_seq = Integer.parseInt(request.getParameter("memory_seq"));
		String memory_comment_name = request.getParameter("memory_comment_name");
		String memory_comment_content = request.getParameter("memory_comment_content");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = ourMemoryService.commentWriteJson(memory_seq, memory_comment_name, memory_comment_content);
		String rt = null;
		
		if(result > 0) {
			ourMemoryService.memoryBoardHit(memory_seq);
			
			MemoryDTO dto = ourMemoryService.memoryBoardView(memory_seq);
			List<MemoryCommentDTO> list = ourMemoryService.commentViewJson(memory_seq);
			
			String[] splitFileName = dto.getMemory_file().split(", ");
			dto.setMemory_file(splitFileName[0]);
			
			modelAndView.addObject("dto", dto);
			modelAndView.addObject("pg", pg);
			modelAndView.addObject("list", list);
			
			
			
			modelAndView.setViewName("index.jsp?req=memoryView");
			
			
		}
		return modelAndView;
	}
}