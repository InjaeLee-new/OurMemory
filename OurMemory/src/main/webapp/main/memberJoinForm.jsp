<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkId() {
	var sId = document.registerform.userId.value;
	if(sId == "") {
		alert("아이디를 먼저 입력하세요.")
		
	} else  {
		// 브라우저창을 관리하는 내장객체   // 요청파일 이름 
		window.open("main/memberCheckId.jsp?userId=" + sId, "",
					// 모니터 크기, 위치 
					"width=350 height=200 left=700 top=400")
	} 
}
</script>
</head>
<body>
	<form name="registerform" method="post" enctype="multipart/form-data" action="memberJoin">
        <div class="fieldlabel">
        	<label for="userId">
        		아이디
        	</label>
        </div>
        <div class="formfield">
        	<input type="text" id="userId" name="userId" maxlength="20" value="" placeholder="아이디 입력" required>
        	<input type="button" value="중복 체크" onclick="checkId()">
        </div>
        <div class="fieldlabel">
        	<label for="userPw">
        		패스워드
        	</label>
        </div>
        <div class="formfield">
			<input type="password" id="userPw" name="userPw" maxlength="20" autocomplete="off" placeholder="패스워드 입력" required>
		</div>
        <div class="fieldlabel">
        	<label for="userPwCheck">
        		패스워드확인
        	</label>
        </div>
        <div class="formfield">
			<input type="password" id="userPwCheck" name="userPwCheck" maxlength="20" autocomplete="off" placeholder="패스워드 확인" required>
		</div>
        <div class="fieldlabel">
        	<label for="userName">
        		이름
        	</label>
        </div>
        <div class="formfield">
        	<input type="text" id="userName" name="userName" maxlength="20" value="" placeholder="이름 입력" required>
        </div>
        <div class="fieldlabel">
        	<label for="nickName">
        		닉네임
        	</label>
        </div>
        <div class="formfield">
        	<input type="text" id="nickName" name="nickName" maxlength="20" value=""placeholder="닉네임 입력" required>
        </div>

        <div class="fieldlabel">
        	<label for="email01">
        		이메일
        	</label>
        </div>
        <div class="formfield">
        	<input type="text" id="email01" name="email01" size="20" maxlength="20" 
             value="" autocomplete="off" placeholder="이메일 입력" required>
             <span>@</span>
            <input id="email02" name="email02" list="domains" placeholder="도메인입력/선택">
            <datalist id="domains">
                <option value="naver.com">
                <option value="daum.net">
                <option value="gmail.com">
                <option value="yahoo.co.kr">
            </datalist>
        </div>
        
        <div class="fieldlabel">
        	<label for="addr">
        		주소
        	</label>
        </div>
        <div class="formfield">
        	<input type="text" id="addr" name="addr" maxlength="20" value=""placeholder="예) 서울시 서초구" required>
        </div>
        
        <div class="fieldlabel">
        	<label>
        		이메일수신
        	</label>
        </div>
        <div class="formfield">
            <input type="radio" name="emailYn" value="1" checked>수신
            <input type="radio" name="emailYn" value="0">미수신
        </div>
        <div class="fieldlabel">
        	<label>
        		SMS수신
        	</label>
        </div>
        <div class="formfield">
            <input type="radio" name="smsYn" value="1"checked>수신
            <input type="radio" name="smsYn" value="0">미수신
        </div>
        <div class="fieldlabel">
        	<label for="mPhone1">
        		연락처
        	</label>
        </div>
        <div class="formfield">
            <select id="mPhone1" name="mPhone1">
                <option value="010" selected>010</option>
                <option value="011">011</option>
                <option value="016">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
            </select>-
            <input id="mPhone2" name="mPhone2" type="number" value="" size="4" maxlength="4" autocomplete="off" placeholder="1234" required>-
            <input id="mPhone3" name="mPhone3" type="number" value="" size="4" maxlength="4" autocomplete="off" placeholder="1234" required>
        </div>
        <div class="fieldlabel">
        	<label>
        		성별
        	</label>
        </div>
        <div class="formfield">
            <input type="radio" name="gender" value="남" alt="남자" checked >남자
            <input type="radio" name="gender" value="여" alt="여자" >여자
        </div>
        <div class="fieldlabel">
        	<label for="profile">
        		프로필사진
        	</label>
        </div>
        <div class="formfield">
            <input type="file" id="profile" name="profile" required>
        </div>
        <div class="btnfield">
            <input type="submit" value="회원가입">
        </div>
    </form>
</body>
</html>
