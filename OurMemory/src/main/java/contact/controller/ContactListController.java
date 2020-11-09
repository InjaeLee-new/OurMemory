package contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import contact.dto.ContactDTO;

@Controller
public class ContactListController {
   @Autowired
   OurMemoryService ourMemoryService;
   
   @RequestMapping(value = "/contactList")
   public ModelAndView contactList (HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      
      
      String contact_id = request.getParameter("userId");
      String contact_pwd = request.getParameter("userPw");
      System.out.print(contact_id);
     
      /*
      int pg = 1;
      if(request.getParameter("pg") != null) {
         if(!request.getParameter("pg").equals("")) {
            pg = Integer.parseInt(request.getParameter("pg"));
         }
      }
      
      int endNum = pg*3;
      int startNum = endNum - 2;
      int totalNum = ourMemoryService.getTotalContact(contact_id);
      int startPage = (pg - 1) / 5 * 5 + 1;

      int endPage = startPage + 4;

      int maxPage = (totalNum - 4) / 5;

      if (endPage > maxPage)
         endPage = maxPage;
      */
      
      
      List<ContactDTO> list = ourMemoryService.contactSelectAll(contact_id);
      
      /*
      modelAndView.addObject("pg", pg);
      modelAndView.addObject("endPage", endPage);
      modelAndView.addObject("startPage", startPage);
      modelAndView.addObject("maxPage", maxPage);
      */
      modelAndView.addObject("list", list);
      
      modelAndView.setViewName("index.jsp?req=contactList");
      
      return modelAndView;
   }
   
   
}