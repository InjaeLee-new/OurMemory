<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="showoffWrite" method="post" enctype="multipart/form-data">
		<table>	
			<tr>
				<td>
					<input type="text" name="board_name" placeholder="작성자 이름을 입력해주세요">
				</td>
				
				<td>
					<input type="text" name="board_pass" placeholder="글 비밀번호를 입력해주세요.">
				</td>
				
				<td>
					<input type="text" name="board_subject" placeholder="글의 제목을 입력해주세요.">
				</td>
				
				<td>
					<input type="text" name="board_content" placeholder="글의 내용을 입력해주세요.">
				</td>
				
				<td>
					<input type="file" name="img">
				</td>
				
			</tr>
			<tr>
				<td colspan="5" align="center">
					<input type="submit" value="이미지 등록">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>