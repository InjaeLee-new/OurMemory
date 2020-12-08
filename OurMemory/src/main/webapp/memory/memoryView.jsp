<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.comment_content {
		width: 800px;
		height: 50px;
	}
	
	body {
	align-content: left;
}
</style>
</head>
<body>
	<table>
		<tr class="imageView">
			<td rowspan="3">
				<img width="400" height="400" alt="" src="./img/${dto.memory_file }">
			</td>
			<td>
				<h1>글 제목 : ${dto.memory_subject }</h1>
			</td>
			<td>
				조회수 : ${dto.memory_hit }
			</td>
		</tr>
		
		<tr>
			<td>
				<h2>글 내용</h2>
				<p>${dto.memory_content }</p>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" onclick="location.href='memory_recommendation?memory_num=${dto.memory_num}&pg=${pg }'" value="이 글을 추천해요!">
				<input type="button" onclick="location.href='memory_notrecommendation?memory_num=${dto.memory_num}&pg=${pg }'" value="이 글이 싫어요!">
				<input type="button" onclick="location.href='memoryList?pg=${i }'" value="목록보기">
			</td>
		</tr>
	</table>
	<div align="left" style="margin-left: 100px">
		<h2>댓글 창</h2>
		<form action="MemoryCommentWrite">
		<pre>
	이름 입력 : <input type="text" name="memory_comment_name" placeholder="이름 입력"><br>
	내용 입력 : <input class="comment_content" name="memory_comment_content" type="text" placeholder="댓글 내용 입력"><br>
	<input type="hidden" name="memory_seq" value="${dto.memory_num }">
	<input type="hidden" name="pg" value="${pg }">
	<input type="submit" value="댓글 작성"> <input type="reset" value="다시 쓰기">
		</pre>
		</form>
	</div>
	<c:forEach var="recommandDTO" items="${list }">
		<p align="left" style="margin-left: 100px">${recommandDTO.memory_comment_name } : ${recommandDTO.memory_comment_content } ${recommandDTO.reg_date }</p>
		<hr style="margin-left: 100px">
	</c:forEach>
</body>
</html>