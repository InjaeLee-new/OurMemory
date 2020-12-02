package android.memory.json;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import appmember.dto.AppMemberDTO;


@Controller
public class AppJoinJson {
	@Autowired 
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/appJoinJson")
	public void appJoinJson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String cate1 = request.getParameter("cate1");
		String cate2 = request.getParameter("cate2");
		String cate3 = request.getParameter("cate3");
		String google_Id = request.getParameter("google_Id");
		String kakao_Id = request.getParameter("kakao_Id");
		
		AppMemberDTO appMemberDTO = new AppMemberDTO();
		appMemberDTO.setId(id);
		appMemberDTO.setCate1(cate1);
		appMemberDTO.setCate2(cate2);
		appMemberDTO.setCate3(cate3);
		appMemberDTO.setGoogle_Id(google_Id);
		appMemberDTO.setKakao_Id(kakao_Id);
		
		int result2 = ourMemoryService.appMemberJoin(appMemberDTO);
		System.out.println("result2 = " + result2);
		// json 문서 만들기
		String rt = null;
			if(result2 >0) {
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
