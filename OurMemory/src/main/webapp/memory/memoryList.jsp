<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/showoff.css?v=1">
</head>
<body>
	<div id="wrap" class="wrap">
		<h1 class="title">추억 모음전</h1>
		<div class="itemlist">
			<c:forEach var="memoryDTO" items="${list }">
			<div class="items">
				<a href="location.href='memoryView'">
				<img alt="추억6" src="img/${memoryDTO.memory_file }">
				</a>
				<p>${memoryDTO.memory_date }</p>
				<div><span class="good">추천 : ${memoryDTO.memory_rec }</span><span class="bad">비추천 : ${memoryDTO.memory_nrec }</span>조회수 : <span class="points">${memoryDTO.memory_hit }</span></div>
				<br> 작성자 : ${memoryDTO.memory_name }
			</div>
			</c:forEach>
    	</div>
    	<input type="button" id="forMemoryButton" value="새 글 추가" onclick="location.href='memoryWriteForm'">
   	</div>
</body>
</html>