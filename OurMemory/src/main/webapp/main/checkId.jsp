<%@page import="OurMemory.service.OurMemoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose() {
		// 내장객체 opener: 현재 브라우저 기준으로 부모 브라우저를 관리하는 객체
		opener.registerform.userId.value = "${userId}";
		window.close();
		opener.registerform.userPw.focus();
	}
	
	function checkId() {
		var frm = document.checkIdForm;
		if(!frm.checkId.value) {
			alert("사용하실 아이디를 입력하세요.")
			frm.checkId.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="memberCheckId" method="post" name="checkIdForm">
	<c:if test="${exist}">
		${userId}는 이미 사용중인 아이디입니다. <br><br>
		아이디 <input type="text" name="checkId">
		<input type="button" value="중복체크" onclick="checkId()">
	</c:if>
	
	<c:if test="${!exist}">
		${userId}는 사용가능한 아이디입니다. <br><br>
		<input type="button" value="사용하기" onclick="checkIdClose()">
	</c:if>
	</form>
</body>
</html>