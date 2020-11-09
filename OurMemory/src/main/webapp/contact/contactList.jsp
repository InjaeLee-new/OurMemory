<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/contact.css?v=5">
</head>
<body>   
   <div id="wrap" class="List_title">
      <h3 class="title">----------------------내 글 목록📚----------------------</h3>
      
       <table class="List_table">
      <tr align="center" class="List_tr">
      	<td width="50">글번호</td>
      	<td width="100">작성자</td>
      	<td width="300">글제목</td>
      	<td>작성일자</td> 
      </tr>
        <c:forEach var="contactDTO" items="${list}">
      <tr align="center" class="List_tr">
         <td>${contactDTO.contact_num}</td>
         <td>${contactDTO.contact_name}</td>
         <td><a href="contactView?contact_num=${contactDTO.contact_num}">${contactDTO.contact_subject}</a></td>
         <td>${contactDTO.contact_logtime}</td>       
      </tr>
         </c:forEach>
       
      </table>
     
     
       
       
       <!-- 
       <div>
       <c:if test="${startPage > 3 }">
                 [<a href="contactList?pg=${startPage -1 }">이전</a>]
            </c:if>
              <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">  
               [<a href="contactList?pg=${i }">${i }</a>]
             </c:forEach>
             <c:if test="${endPage < maxPage }">
                [<a href="contactList?pg=${endPage + 1 }">다음</a>]
         </c:if>  
         </div> 
        -->
         
      
      
      <br>
       <input class="button_List" type="button" value="뒤로가기" onclick="history.back()">
       <input class="button_List" type="button" id="addContactButton" value="새 글 추가" onclick="location.href='contactForm'">
      </div>
   <br>
</body>
</html>