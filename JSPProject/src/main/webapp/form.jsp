<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>form.jsp</title>
</head>

<body>
	<form name="frm" action="StudentGetServlet" method="get">
		<input type="hidden" name="cmd" value="search">
		ID: <input type="number" name="user_id" value=""><br>
		Name: <input type="text" name="user_name" value=""><br>
		Eng : <input type="number" name="eng_score" value=""><br>
		Kor: <input type="number" name="kor_score" value=""><br>
		<input type="submit" value="조회">
		<input type="button" value="입력" id="addBtn">
		<input type="button" value="수정" id="modBtn">
		<input type="button" value="삭제" id="delBtn">
	</form>

	<script>
		let addBtn = document.querySelector('#addBtn');
		addBtn.addEventListener('click', () => {
			// documnet 밑에 있는 form 태그를 모두 컬렉션으로 가져온것중에 frm 이라고 이름 붙여진것을 선택
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";
			frm.submit();
		});

		let delBtn = document.querySelector('#delBtn');
		delBtn.addEventListener('click', () => {
			// documnet 밑에 있는 form 태그를 모두 컬렉션으로 가져온것중에 frm 이라고 이름 붙여진것을 선택
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "del";
			frm.submit();
		});
		
		let modBtn = document.querySelector('#modBtn');
		modBtn.addEventListener('click', () => {
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "mod";
			frm.submit();
		});

	</script>
	<hr>
	<a href="./studentList.jsp">학생목록</a>
	
</body>

</html>