<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="model.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="5" />
	</jsp:include>
	<div id="allShow">
		<%
		List<Student> students = Model.getAllStudents();
		request.setAttribute("size", students.size());
		%>
		<div id="excel-data" class="file-result-wrap show-excel-table">
			<ul class="users-ul">
				<li class="user-title-li"><span class="user-title-span">学号</span>
					<span class="user-title-span">姓名</span> <span
					class="user-title-span">手机号</span> <span class="user-title-span">性别</span>
					<span class="user-title-span">年龄</span> <span
					class="user-title-span">学院</span> <span class="user-title-span">班级</span>
					<span class="user-title-span">相片</span></li>
				<%
				if (students.size() > 0) {

					for (int i = 0; i < students.size(); i++) {
				%>

				<li class="user-item-li"><span class="user-item-span"><%=students.get(i).getSid()%></span>
					<span class="user-item-span"><%=students.get(i).getSname()%></span>
					<span class="user-item-span"><%=students.get(i).getSphone()%></span>
					<span class="user-item-span"><%=students.get(i).getSsex()%></span>
					<span class="user-item-span"><%=students.get(i).getSage()%></span>
					<span class="user-item-span"><%=students.get(i).getScollege()%></span><span
					class="user-item-span"><%=students.get(i).getSclass()%></span><span
					class="user-item-span"><img
						src="<%=students.get(i).getSimg()%>" /></span></li>
				<%
				}

				} else {
				%>
				<li class="user-item-li"><span class="user-item-span null">空</span>
				</li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</body>
</html>