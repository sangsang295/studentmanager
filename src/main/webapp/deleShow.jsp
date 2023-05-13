<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${msg }</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="2" />
	</jsp:include>
	<div id="deleShow">
		<div class="msg-wrap show">
			<h3 class="msg" style="color: ${color };">${msg }</h3>
		</div>
		<c:if test="${!empty student }">
			<div id="excel-data"
				class="file-result-wrap show-excel-table">
				<ul class="users-ul">
					<li class="user-title-li"><span class="user-title-span">学号</span>
						<span class="user-title-span">姓名</span> <span
						class="user-title-span">手机号</span> <span class="user-title-span">性别</span>
						<span class="user-title-span">年龄</span> <span
						class="user-title-span">学院</span>
						<span
						class="user-title-span">班级</span>
						<span
						class="user-title-span">相片</span></li>
					<li class="user-item-li"><span class="user-item-span">${student.sid }</span>
						<span class="user-item-span">${student.sname }</span> <span
						class="user-item-span">${student.sphone }</span> <span
						class="user-item-span">${student.ssex }</span> <span
						class="user-item-span">${student.sage }</span> <span
						class="user-item-span">${student.scollege }</span> <span
						class="user-item-span">${student.sclass }</span><span
						class="user-item-span"><img src="${student.simg }"/></span></li>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>