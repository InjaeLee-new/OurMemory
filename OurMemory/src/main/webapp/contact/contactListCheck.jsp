<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/contact.css?v=5">
</head>
<body>
<form action="contactList" method="post" enctype="multipart/form-data">
<h4 class="Check_title">소중한 문의사항 관리를 위한<br>----------------------${name }님 개인정보를 한번만 확인해볼게요! 🙏----------------------</h4>
<table>
		<tr class="Check_tr"> 
			<td id="userId" align="center" width="120">아이디</td>
			<td><input type="text" id="userId" name ="userId" maxlength="20" required="required" value="${id }"></td>
		</tr>
		<tr class="Check_tr"> 
			<td id="userPw" align="center" width="100">패스워드</td>
			<td><input type="password" id="userPw" name ="userPw" maxlength="20" autocomplete="off" required="required"></td>
		</tr>
			<tr>
			<td colspan="2" align="center">
			<br>		
			<input class="button_Check" type="button" value="뒤로가기" onclick="history.back()">		
			<input class="button_Check" type="submit" value="입력 완료">
			<input class="button_Check" type="reset" value="다시 작성">
		</tr>
				
	</table>
<br>
</form>
</body>
</html>