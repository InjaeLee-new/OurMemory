package android.memory.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import OurMemory.service.OurMemoryService;
import appmember.dto.AppMemberDTO;
import member.dto.MemberDTO;

@Controller
public class JoinJson {
	
	@Autowired 
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/joinJson")
	public void joinJson(HttpServletRequest request, HttpServletResponse response, MultipartFile profile) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
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
		
		
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		//String profile_image = request.getParameter("profile_image");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setNickname(nickname);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		memberDTO.setProfile_image(fileName);
		
		int result1 = ourMemoryService.memberJoin(memberDTO);
		
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
		
		// json 문서 만들기
		String rt = null;
		if(result1 > 0 && result2 >0) {
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
