<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리들의 추억 저장소</title>
<link rel="stylesheet" type="text/css" href="./css/index2.css?v=8">
</head>
<body>
	<div class="menubar" >
		<c:if test="${isLogin != null }">
			<ul>
				<li id="title"><a href="index.jsp" style="text-align: center"><img alt="배너용 사진" src="img/main1.png" width="110px"></a></li>
					<li id="storyboard">
						<a>우리들의 추억 👪</a>
						<ul>
							<li>
								<a href="showoffList">우리 함께 🐶</a>
							</li>
							<li>
								<a href="memoryList">어디든 📍</a>
							</li>		
						</ul>
					<li id="introduce">
						<a>나의 추억 🙋‍♀</a>
						<ul>
							<li>
								<a href="showoffMyList">너와 🐶</a>
							</li>
							<li>
								<a href="memoryMyList">여기 📍 </a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="contact">우추소에 질문 💌</a>
					</li>
					<li id="myInform">
						<a href="myInform">
							마이페이지 💭
						</a>
					</li>
					
					<li id="memberLogout">
						<a href="memberLogout">
							로그아웃 👋
						</a>
					</li>
					<li>
						<p style="">
							${name }(${nickname })님 안녕하세요!
						</p>
					</li>
					
			</ul>
			<img alt="배너용 사진" src="img/mainreresmall.png" width="1600px" height="400px"><br>
			
			<input type = "hidden" value = "값">
	<div class="center" align="center">
   	
		<c:if test="${param.req == null }">
			<!--<jsp:include page="./main/mainpage.jsp" /> -->
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
		<c:if test="${param.req == 'showoffMyList' }">
			<jsp:include page="./showoff/showoffMyList.jsp" />
		</c:if>
		<c:if test="${param.req == 'memoryList' }">
			<jsp:include page="./memory/memoryList.jsp" />
		</c:if>
		<c:if test="${param.req == 'memoryMyList' }">
			<jsp:include page="./memory/memoryMyList.jsp" />
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
		<c:if test="${param.req == 'memoryMyView' }">
			<jsp:include page="./memory/memoryMyView.jsp" />
		</c:if>
		<c:if test="${param.req == 'showoffView' }">
			<jsp:include page="./showoff/showoffView.jsp" />
		</c:if>	
		<c:if test="${param.req == 'showoffMyView' }">
			<jsp:include page="./showoff/showoffMyView.jsp" />
		</c:if>	
		<c:if test="${param.req == 'contact' }">
			<jsp:include page="./contact/contact.jsp" />
		</c:if>	
		<c:if test="${param.req == 'contactPro' }">
			<jsp:include page="./contact/contactResult.jsp" />
		</c:if>		
		<c:if test="${param.req == 'myInform' }">
			<jsp:include page="./main/memberInformation.jsp" />
		</c:if>	
		 
      <c:if test="${param.req == 'contactForm' }">
         <jsp:include page="./contact/contactForm.jsp" />
      </c:if>  
      <c:if test="${param.req == 'contactListCheck' }">
         <jsp:include page="./contact/contactListCheck.jsp" />
      </c:if>  
      <c:if test="${param.req == 'contactList' }">
         <jsp:include page="./contact/contactList.jsp" />
      </c:if> 
      
      <c:if test="${param.req == 'contactView' }">
         <jsp:include page="./contact/contactView.jsp" />
      </c:if> 
      <c:if test="${param.req == 'contactUpdate' }">
         <jsp:include page="./contact/contactUpdate.jsp" />
      </c:if> 
      
      <c:if test="${param.req == 'contactDelete' }">
         <jsp:include page="./contact/contactDelete.jsp" />
      </c:if>
		
	</div>
	<div id="footer" style="border-top: 1px solid; width: 1600px; margin: 0 auto;">
		<br>&copy;우리들의 추억 저장소<br>
		문의전화 : 1644-0685<br>
		주      소 : 서울특별시 강남구 이젠로 302-1 이젠IT아카데미 
	</div>
	</c:if>
	<c:if test="${isLogin == null }">
		<div id="mainLeft">
			<img style="align-content: center;" alt="메인 사진" src="img/main1.png" width="1200px" height="600px"><br>
		</div>
		
		<div id="mainRight">
			<jsp:include page="./main/memberLoginForm.jsp" />
			<a href="index.jsp?req=join">
				회원가입!
			</a>
		</div>
	</c:if>
	</div>
	
	
</body>
</html>