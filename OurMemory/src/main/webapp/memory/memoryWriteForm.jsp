<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memoryWrite" method="post" enctype="multipart/form-data">
		<table>	
			<tr>
				<td>
					<input type="text" name="memory_name" placeholder="작성자 이름을 입력해주세요" required="required">
				</td>
				
				<td>
					<input type="text" name="memory_pass" placeholder="글 비밀번호를 입력해주세요." required="required">
				</td>
				
				<td>
					<input type="text" name="memory_subject" placeholder="글의 제목을 입력해주세요." required="required">
				</td>
				
				<td>
					<input type="text" name="memory_content" placeholder="글의 내용을 입력해주세요." required="required">
				</td>
				
				<td>
					<input type="file" name="img" required="required">
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