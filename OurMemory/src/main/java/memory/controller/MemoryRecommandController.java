package memory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class MemoryRecommandController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	// 추천에 관한 Controller
	@RequestMapping(value = "/memory_recommendation")
	public ModelAndView memory_recommendation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("..");
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		MemoryDTO dto = ourMemoryService.memoryBoardView(memory_num);
		int result = ourMemoryService.memoryBoardRec(memory_num);
		
		if(result > 0) {
			// alert창을 띄우기 위해 사용
			try {
				PrintWriter out = response.getWriter();
				out.println("<script language = 'javascript'>");
				out.println("alert('추천을 누르셨습니다!');");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelAndView.addObject("dto", dto);
			modelAndView.addObject("pg", pg);
			modelAndView.setViewName("index.jsp?req=memoryView");
		}
		else {
			// 여기에 히스토리 백이랑 알러트
			// alert창을 띄우기 위해 사용
			try {
				PrintWriter out = response.getWriter();
				out.println("<script language = 'javascript'>");
				out.println("alert('오류 발생');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return modelAndView;
	}
	// 비추천에 관한 Controller
	@RequestMapping(value = "/memory_notrecommendation")
	public ModelAndView memory_notrecommendation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		MemoryDTO dto = ourMemoryService.memoryBoardView(memory_num);
		int result = ourMemoryService.memoryBoardNrec(memory_num);
		
		if(result > 0) {
			// alert창을 띄우기 위해 사용
			try {
				PrintWriter out = response.getWriter();
				out.println("<script language = 'javascript'>");
				out.println("alert('비추천을 누르셨습니다!');");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			modelAndView.addObject("dto", dto);
			modelAndView.addObject("pg", pg);
			modelAndView.setViewName("index.jsp?req=memoryView");
		}
		else {
			// 여기에 히스토리 백이랑 알러트
			// alert창을 띄우기 위해 사용
			try {
				PrintWriter out = response.getWriter();
				out.println("<script language = 'javascript'>");
				out.println("alert('오류 발생');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return modelAndView;
	}
}
