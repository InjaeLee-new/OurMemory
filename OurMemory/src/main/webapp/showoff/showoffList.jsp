<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="./css/showoff.css?v=2">
</head>
<body>
	<div class="wrap">
		<h1 class="title">귀요미들 사진첩</h1>
		<div class="itemlist">
			<c:forEach var="showoffDTO" items="${list }">
			<div class="items">
				<a href="showoffView?board_num=${showoffDTO.board_num }&pg=1">
				<img alt="추억6" src="img/${showoffDTO.board_file }">
				</a>
				<br> 제목 : ${showoffDTO.board_subject }
				<p>${showoffDTO.board_date }</p>
				<div><span class="good">추천 : ${showoffDTO.board_rec }</span><span class="bad">비추천 : ${showoffDTO.board_nrec }</span>조회수 : <span class="points">${showoffDTO.board_hit }</span></div>
				<br> 작성자 : ${showoffDTO.board_name }
			</div>
			</c:forEach>
    	</div>
    	
    	<div>
				<c:if test="${startPage > 3 }">
	            	[<a href="showoffList?pg=${startPage -1 }">이전</a>]
        	 	</c:if>
            	<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">  
        			 	[<a href="showoffList?pg=${i }">${i }</a>]
    	     	</c:forEach>
    	     	<c:if test="${endPage < maxPage }">
	         	[<a href="showoffList?pg=${endPage + 1 }">다음</a>]
				</c:if>
		</div>
		
		<br>
		<input type="button" id="forshowoffButton" value="새 글 추가" onclick="location.href='showoffWriteForm'">
   	</div>
</body>
</html>