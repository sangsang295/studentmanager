<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>吴彦组——实验四(1)——搜索</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet"
	href="./iconfont/font_2972909_3oef5s7kzs9/iconfont.css" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/search.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<div id="app" class="search">
		<jsp:include page="nav.jsp">
			<jsp:param name="active" value="4" />
		</jsp:include>
		<div class="search-form-wrap">
			<form id="search-form" name="search-form"
				action="${pageContext.request.contextPath }/searchServlet"
				method="GET">
				<div class="key-box">
					<c:if test="${!empty student }">
						<input id="key" class="key" value="${student.sid }" type="text"
							name="keyword" required autocomplete="off" />
					</c:if>
					<c:if test="${empty student }">
						<input id="key" class="key" type="text" name="keyword" required
							autocomplete="off" />
					</c:if>
					<label for="key" class="key-placeholder">请输入ID查询</label>
				</div>
				<button class="search-btn iconfont" type="submit">&#xe664;</button>
			</form>
		</div>
	</div>
</body>
</html>