<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회   원   명 : ${dto.user_name }<br>
	회원아이디 : ${dto.user_id }<br>
	비 밀 번 호 : ${dto.pwd }<br>
	별         명 : ${dto.nickname }<br>
	이   메   일 : ${dto.email1 } @ ${dto.email2 }<br>
	전 화 번 호 : ${dto.tel1 } - ${dto.tel2 } - ${dto.tel3 }<br>
	주         소 : ${dto.addr }<br>
	

</body>
</html>