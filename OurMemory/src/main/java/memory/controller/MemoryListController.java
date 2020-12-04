package memory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class MemoryListController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memoryList")
	public ModelAndView memoryList(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			if(!request.getParameter("pg").equals("")) {
				pg = Integer.parseInt(request.getParameter("pg"));
			}
		}
		
		int endNum = pg * 8 ;
		
		int startNum = endNum - 7 ;
		
		int totalNum = ourMemoryService.getTotalMemory();

		int startPage = (pg - 1) / 5 * 5 + 1;

		int endPage = startPage + 4;

		int maxPage = (totalNum - 4) / 5;

		if (endPage > maxPage)
			endPage = maxPage;
		
		List<MemoryDTO> list = ourMemoryService.memoryBoardList(startNum, endNum);
		
		String fileSplit1[] = list.get(0).getMemory_file().split(", ");
		String fileSplit2[] = list.get(1).getMemory_file().split(", ");
		String fileSplit3[] = list.get(2).getMemory_file().split(", ");
		String fileSplit4[] = list.get(3).getMemory_file().split(", ");
		String fileSplit5[] = list.get(4).getMemory_file().split(", ");
		String fileSplit6[] = list.get(5).getMemory_file().split(", ");
		String fileSplit7[] = list.get(6).getMemory_file().split(", ");
		String fileSplit8[] = list.get(7).getMemory_file().split(", ");
		
		String file_Name[] = new String[list.size()];
		
		file_Name[0] = fileSplit1[0];
		file_Name[1] = fileSplit2[0];
		file_Name[2] = fileSplit3[0];
		file_Name[3] = fileSplit4[0];
		file_Name[4] = fileSplit5[0];
		file_Name[5] = fileSplit6[0];
		file_Name[6] = fileSplit7[0];
		file_Name[7] = fileSplit8[0];
		
		for(int i = 0 ; i < file_Name.length; i++) {
			list.get(i).setMemory_file(file_Name[i]);
		}
		
		modelAndView.addObject("pg" , pg);
		modelAndView.addObject("endPage" , endPage);
		modelAndView.addObject("startPage" , startPage);
		modelAndView.addObject("maxPage" , maxPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("file_Name", file_Name);
		
		modelAndView.setViewName("index.jsp?req=memoryList");
		
		return modelAndView;
	}
	
}
