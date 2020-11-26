//package android.memory.json;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.simple.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import OurMemory.service.OurMemoryService;
//import recommand.dto.RecommandDTO;
//
//@Controller
//public class ArtListJson {
//	@Autowired
//	OurMemoryService ourMemoryService;
//	
//	// Android에서 추천 중복 불가에 대한 코드
//	@RequestMapping(value = "/recommandCheck")
//	public void recommendation
//	(HttpServletRequest request, HttpServletResponse response) {
//	
//		int recommand_seq = Integer.parseInt(request.getParameter("recommand_seq"));
//		String recommand_id = request.getParameter("recommand_id");
//		System.out.println(recommand_id+" = recommand_id");
//		int result = ourMemoryService.recommandCheck(recommand_seq, recommand_id);
//		System.out.println(result+" = result");
//		
//		String rt = "Exist"; 
//	    if(result == 0) {
//	    	RecommandDTO dto = new RecommandDTO();
//	    	dto.setRecommand_id(recommand_id);
//	    	dto.setRecommand_seq(recommand_seq);
//	    	int result2 = ourMemoryService.recommandInsert(dto);
//	    	System.out.println(result2+" = result2");
//	    	if (result2 > 0) {
//	    		rt = "OK";	    		
//	    	}
//	    }
//		JSONObject json = new JSONObject();
//		json.put("rt",rt);
//		try {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println(json);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
