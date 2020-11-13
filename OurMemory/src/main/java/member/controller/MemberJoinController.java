package member.controller;

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
import member.dto.MemberDTO;

@Controller
public class MemberJoinController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberJoin")
	public ModelAndView memberJoin(HttpServletRequest request, HttpServletResponse response, MultipartFile profile) throws Exception {
		String filePath = "C:\\Users\\USER\\git\\repository\\OurMemory\\src\\main\\webapp\\img";
		
		String fileName = profile.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		
		// 파일 복사
		// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
		try {
			FileCopyUtils.copy(profile.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_name(request.getParameter("userName"));
		memberDTO.setUser_id(request.getParameter("userId"));
		memberDTO.setPwd(request.getParameter("userPw"));
		memberDTO.setNickname(request.getParameter("nickName"));
		memberDTO.setGender(request.getParameter("gender"));
		memberDTO.setEmail1(request.getParameter("email01"));
		memberDTO.setEmail2(request.getParameter("email02"));
		memberDTO.setTel1(request.getParameter("mPhone1"));
		memberDTO.setTel2(request.getParameter("mPhone2"));
		memberDTO.setTel3(request.getParameter("mPhone3"));
		memberDTO.setCheck_email(Integer.parseInt(request.getParameter("emailYn")));
		memberDTO.setCheck_sms(Integer.parseInt(request.getParameter("smsYn")));
		memberDTO.setAddr(request.getParameter("addr"));
		memberDTO.setProfile_image(fileName);
		
		int result = ourMemoryService.memberJoin(memberDTO);
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=joinPro");
		
		return modelAndView;
	}
}
