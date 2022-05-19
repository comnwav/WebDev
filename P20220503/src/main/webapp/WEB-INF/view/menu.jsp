<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>

<body>

	<div class="border-end bg-white" id="sidebar-wrapper">
		<div class="list-group list-group-flush">
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/memberView/memberInsert.tiles">Member Insert</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/memberView/memberSearch.tiles">Search Member</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/memberView/memberUpdate.tiles">Modify Member</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/memberView/memberDelete.tiles">Delete Member</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/memberList.do">List Member</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/ajax.html">Ajax</a>
		</div>
	</div>

</body>

</html>