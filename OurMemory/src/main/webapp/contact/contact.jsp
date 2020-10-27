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
<form name="contactform" method="post" enctype="multipart/form-data" action="contact">
	<div class="wrap">
		<h1 class="title">Contact Us</h1>
		
        	<label for="userId">
        		아이디
        	</label>       
        	<input type="text" id="userId" name="userId" maxlength="20" value="">
       		<br>
        	<label for="userPw">
        		패스워드
        	</label>
			<input type="password" id="userPw" name="userpPw" maxlength="20" autocomplete="off">
			<br>
        	<label for="userName">
        		이름
        	</label>
       		<input type="text" id="userName" name="userName" maxlength="20" value="">
       		<br>
        	<label for="nickName">
        		닉네임
        	</label>
        	<input type="text" id="nickName" name="nickName" maxlength="20" value="">
        	<br>

        	<label for="email01">
        		이메일
        	</label>
        
        	<input type="text" id="email01" name="email01" size="20" maxlength="20" 
             value="" autocomplete="off">
             <span>@</span>
            <input id="email02" name="email02" list="domains" placeholder="도메인입력/선택">
            <datalist id="domains">
                <option value="naver.com">
                <option value="daum.net">
                <option value="gmail.com">
                <option value="yahoo.co.kr">
            </datalist>
        
    		<br>
        	<label for="mPhone1">
        		연락처
        	</label>
       		<select id="mPhone1" name="mPhone1">
                <option value="010" selected>010</option>
                <option value="011">011</option>
                <option value="016">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
            </select>-
            <input id="mPhone2" name="mPhone2" type="number" value="" size="4" maxlength="4" autocomplete="off">-
            <input id="mPhone3" name="mPhone3" type="number" value="" size="4" maxlength="4" autocomplete="off">
        <br>
        	<label for="reason">
        		컨택사유
        	</label>
       <select id="reason" name="reason">
                <option value="게시글" selected>게시글</option>
                <option value="계정">계정</option>
                <option value="보안">보안</option>
                <option value="FAQ">FAQ</option>
                <option value="기타문의">기타문의</option>
                
            </select>
        <br>
        	<label for="subject">
        		제목
        	</label>
        
        	<input type="text" id="subject" name="subject" maxlength="20" value="">
        
        <br>
        <div>
        	<label for="message">
        		전하고 싶은 말
        	</label>
        </div>
        	
       
        
        	<textarea id="message" name="message" rows="20" cols="50"></textarea>
        
        
		<br>
		<input type="submit" value="등록">
   	
   	 </form>
</body>
</html>
