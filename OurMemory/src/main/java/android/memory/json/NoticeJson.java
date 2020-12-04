package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import contact.dto.NoticeDTO;
import contact.dto.QuestionDTO;

@Controller
public class NoticeJson {
   @Autowired
   OurMemoryService ourMemoryService;
   
   @SuppressWarnings("unchecked")
   @RequestMapping(value = "/questionJson")
   public void questionJson(HttpServletRequest request, HttpServletResponse response) {
      
      List<QuestionDTO> list = ourMemoryService.questionList();
      
      String rt = "실패";
      if(list != null) {
         
         rt = "성공!!";
         JSONObject json = new JSONObject();
         json.put("rt", rt);
         json.put("total", list.size());
         
         JSONArray noticeList = new JSONArray();
         
         for(int i = 0 ; i < list.size() ; i++) {
             JSONObject select = new JSONObject();
              select.put("num", list.get(i).getQuestion_num());
              select.put("logtime", list.get(i).getQuestion_logtime());
              select.put("subject", list.get(i).getQuestion_subject());
              select.put("content", list.get(i).getQuestion_content());
              noticeList.add(select);
         }
         
         json.put("noticeList", noticeList);
         
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
   
   @SuppressWarnings("unchecked")
   @RequestMapping(value = "/noticeJson")
   public void noticeJson(HttpServletRequest request, HttpServletResponse response) {
      
      List<NoticeDTO> list = ourMemoryService.noticeList();
      
      String rt = null;
      if(list != null) {
         
         rt = "성공!!";
         JSONObject json = new JSONObject();
         json.put("rt", rt);
         json.put("total", list.size());
         
         JSONArray noticeList = new JSONArray();
         
         for(int i = 0 ; i < list.size() ; i++) {
             JSONObject select = new JSONObject();
              select.put("num", list.get(i).getNotice_num());
              select.put("logtime", list.get(i).getNotice_logtime());
              select.put("subject", list.get(i).getNotice_subject());
              select.put("content", list.get(i).getNotice_content());
              
              noticeList.add(select);
         }
         
         json.put("noticeList", noticeList);
         
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
}