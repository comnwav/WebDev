<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
let url = 'StudentGetServlet';
fetch(url)
.then(result => {
	return result.json(); // {"id":23, "name":"hong"}
})
.then(result => {
	console.log(result);
})
.catch(error => {
	console.log(error);
});
</script>

</body>
</html>