<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=3">
</head>
<body>
	<div class="menubar" >
		<ul>
			<li id="title"><a href="index.jsp" style="text-align: center">Our Gallery</a></li>
				<li id="storyboard">
					<a>게시판</a>
					<ul>
						<li>
							<a href="showoffList">귀요미들 사진첩</a>
						</li>
						<li>
							<a href="memoryList">추억 저장소?</a>
						</li>		
					</ul>
				<li id="introduce">
					<a>내가 올린 글만 보기</a>
					<ul>
						<li>
							<a href="#">내 동물자랑</a>
						</li>
						<li>
							<a href="#">내 추억자랑</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="index.jsp?req=contact">Contact Us</a>
				</li>
				
				<li id="login">
					<a href="index.jsp?req=login">
						로그인!
					</a>
				</li>
				
				<li id="join">
					<a href="index.jsp?req=join">
						회원가입!
					</a>
				</li>

		</ul>
		
			<img alt="배너용 사진" src="img/banner.jpg" width="1600px" height="300px"><br>
	
	</div>
	<input type = "hidden" value = "값">
	<div class="center" align="center">
   	
		<c:if test="${param.req == null }">
			<jsp:include page="./main/mainpage.jsp" />
		</c:if>
		<c:if test="${param.req == 'login' }">
			<jsp:include page="./main/memberLoginForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'loginPro' }">
			<jsp:include page="./main/memberLogin.jsp" />
		</c:if>
		<c:if test="${param.req == 'join' }">
			<jsp:include page="./main/memberJoinForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'joinPro' }">
			<jsp:include page="./main/memberJoin.jsp" />
		</c:if>
		<c:if test="${param.req == 'showoffList' }">
			<jsp:include page="./showoff/showoffList.jsp" />
		</c:if>
		<c:if test="${param.req == 'memoryList' }">
			<jsp:include page="./memory/memoryList.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeMemory' }">
			<jsp:include page="./memory/memoryWriteForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeMemoryPro' }">
			<jsp:include page="./memory/memoryWrite.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeShowOff' }">
			<jsp:include page="./showoff/showoffWriteForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeShowOffPro' }">
			<jsp:include page="./showoff/showoffWrite.jsp" />
		</c:if>		
		<c:if test="${param.req == 'memoryView' }">
			<jsp:include page="./memory/memoryView.jsp" />
		</c:if>
		<c:if test="${param.req == 'showoffView' }">
			<jsp:include page="./showoff/showoffView.jsp" />
		</c:if>	
		<c:if test="${param.req == 'contact' }">
			<jsp:include page="./contact/contact.jsp" />
		</c:if>	
		
	</div>
	
	<div id="footer" style="border-top: 1px solid; width: 1600px; margin: 0 auto;">
		&copy;우리팀<br>
		문의전화 : 010 - xxxx - xxxx<br>
		주      소 : 서울특별시 강남구 이젠로 302-1 이젠it아카데미 
	</div>
</body>
</html>
