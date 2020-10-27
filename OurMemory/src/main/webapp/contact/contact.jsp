<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>

</head>
<body>
<form action="contact" name="contactform" method="post" enctype="multipart/form-data" >
	
		<h1 class="title">Contact Us</h1>
			<table>
				<tr> 
					<td id="userId" align="center" width="120">아이디</td>
					<td><input type="text" id="userId" name ="userId" maxlength="20"></td>
				</tr>
				<tr> 
					<td id="userPw" align="center" width="100">패스워드</td>
					<td><input type="password" id="userPw" name ="userPw" maxlength="20" autocomplete="off"></td>
				</tr>
				<tr> 
					<td id="userName" align="center" width="100">이름</td>
					<td><input type="text" id="userName" name ="userName" maxlength="20"></td>
				</tr>
				<tr> 
					<td id="nickName" align="center" width="100">닉네임</td>
					<td><input type="text" id="nickName" name ="nickName" maxlength="15"></td>
				</tr>
				
				<tr> 
					<td id="email" align="center" width="100">이메일</td>
					<td>
						<input type="text" id="email01" name="email01" size="20" maxlength="20" value="" autocomplete="off">
             			<span>@</span>
            			<input id="email02" name="email02" list="domains" placeholder="도메인입력/선택">
            				<datalist id="domains">
                				<option value="naver.com">
                				<option value="daum.net">
                				<option value="gmail.com">
                				<option value="yahoo.co.kr">
            				</datalist>
					</td>
				</tr>
				
				<tr> 
					<td id="mPhone" align="center" width="100">연락처</td>
					<td>
						<select id="mPhone1" name="mPhone1">
                			<option value="010" selected>010</option>
                			<option value="011">011</option>
                			<option value="016">017</option>
                			<option value="018">018</option>
                			<option value="019">019</option>
            			</select>-
            			<input id="mPhone2" name="mPhone2" type="text" value="" size="4" maxlength="4" autocomplete="off">-
            			<input id="mPhone3" name="mPhone3" type="text" value="" size="4" maxlength="4" autocomplete="off">
            		</td>
				</tr>
				
				<tr> 
					<td id="reason" align="center" width="100">컨택사유</td>
					<td>
						<select id="reason" name="reason">
               				<option value="게시글" selected>게시글</option>
                			<option value="계정">계정</option>
                			<option value="보안">보안</option>
                			<option value="FAQ">FAQ</option>
                			<option value="기타문의">기타문의</option>          
            			</select>
            		</td>
				</tr>
				
				<tr> 
					<td id="subject" align="center" width="100">글제목</td>
					<td><input type="text" id="subject" name ="subject" maxlength="100"></td>
				</tr>
				
				<tr> 
					<td id="message" align="center" width="100">전하고 싶은 말</td>
					<td><textarea id="message" name="message" rows="20" cols="50"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="등록">
				</tr>
				
			</table>
   	 </form>
</body>
</html>
