<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>吴彦祖</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<div id="app">
		<!--<video class="bg" src="./videos/bg.mp4" muted autoplay loop></video>-->
		<!--  <div class="index-welcome">Hello, Welcome !</div>-->
		<jsp:include page="nav.jsp">
			<jsp:param name="active" value="0" />
		</jsp:include>
	</div>
</body>
</html>