<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>吴彦组</title>
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
		<jsp:param name="active" value="3" />
	</jsp:include>
	<div id="update">
		<div class="update-form-wrap">
			<form id="insert-form"
				action="${pageContext.request.contextPath }/updateServlet"
				method="post" enctype="multipart/form-data">
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uid" type="text"
						name="sid" required /> <label class="input-placeholder"
						for="uid">请输入需要修改的学生ID</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uname" type="text"
						name="sname" required /> <label class="input-placeholder"
						for="uname">请输入新的姓名</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uphone" type="text"
						name="sphone" required /> <label class="input-placeholder"
						for="uphone">请输入新的手机号</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uage" type="text"
						name="sage" required /> <label class="input-placeholder"
						for="uage">请输入新的年龄</label>
				</div>
				<div class="input-wrap">
					<input id="sex-man" type="radio" value="男" name="ssex" checked />
					<label for="sex-man" style="margin-right: 20px;">男</label> <input
						id="sex-woman" type="radio" value="女" name="ssex" /> <label
						for="sex-woman">女</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="ucollege" type="text"
						name="scollege" required /> <label class="input-placeholder"
						for="ucollege">请输入新的学院</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uclass" type="text"
						name="sclass" required /> <label class="input-placeholder"
						for="uclass">请输入新的班级</label>
				</div>
				<div class="input-wrap img-wrap">
					<input id="img-input" type="file" name="simg" accept="image/*"/>
					<label id="img-input-label" for="img-input">选择相片</label>
					<img id="simg-dom" src=""/>
				</div>
				<button type="submit" id="insert-input-btn">提交</button>
				
				<script type="text/javascript">
					let imgInput = document.getElementById("img-input");
					let img = document.getElementById("simg-dom");
					imgInput.addEventListener("change", function(){
						var file = this.files[0];
						if(file != undefined){
							if(file.type.lastIndexOf("image/") > -1){
								let src = URL.createObjectURL(file);
								img.src = src;
							}else {
								imgInput.value = "";
								img.src = "";
								alert("仅支持图片文件");
							}
						}else {
							img.src = "";
							imgInput.value = "";
						}
					});
				</script>
			</form>
		</div>
	</div>
</body>
</html>