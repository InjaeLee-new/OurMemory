<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		메인 페이지에 구성할 내용<br>
		게시판에 원하는 내용으로 이동해주세요<br>
		IJ's Gallery를 클릭하면 메인 페이지로 돌아옵니다.
		
		추억 모음전과, 반려동물 자랑하기 추천수 TOP 3 게시글이 노출 된다.
		원하는건 서브쿼리로 비추천수까지 해서 도합 랭킹을 매기는 것.
	</div>
	
	<div>
		<div align="left">
				반려동물 자랑하기 TOP 3 랭킹된 내용이 표시됨. 추천수에 따라 순위는 추후에 변동됨.
				<c:forEach var="showoffDTO" items="${topshowList }">
					<a>${i } = ${showoffDTO.board_name } </a>
				</c:forEach>
				<c:if test="${topshowList.size() == 0 }">
					현재 넘어온 데이터가 없네여.
				</c:if>
		</div>
		<div align="right">
				추억 저장소 TOP 3 랭킹된 내용이 표시됨. 추천수에 따라 순위는 추후에 변동됨.
				<c:forEach var="memoryDTO" items="${topmemoryList }">
					<a>${i } = ${memoryDTO.memory_name } </a>
				</c:forEach>
				<c:if test="${topmemoryList.size() == 0 }">
					현재 넘어온 데이터가 없네여.
				</c:if>
		</div>
	</div>	
</body>
</html>