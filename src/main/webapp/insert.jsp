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
<link rel="stylesheet"
	href="./iconfont/font_2972909_3oef5s7kzs9/iconfont.css" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
<script type="text/javascript" src="./js/xlsx.core.min.js"></script>
<script type="text/javascript" src="./js/insert.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<div id="app">
		<jsp:include page="nav.jsp">
			<jsp:param name="active" value="1" />
		</jsp:include>
		<div class="form-wrap">
			<form id="insert-form" action="${pageContext.request.contextPath }/insertByInputServlet" method="post" enctype="multipart/form-data">
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uname" type="text"
						name="sname" required /> <label class="input-placeholder"
						for="uname">请输入学生姓名</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uphone" type="text"
						name="sphone" required /> <label class="input-placeholder"
						for="uphone">请输入学生手机号</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uage" type="text"
						name="sage" required /> <label class="input-placeholder"
						for="uage">请输入学生年龄</label>
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
						for="ucollege">请输入学院</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uclass" type="text"
						name="sclass" required /> <label class="input-placeholder"
						for="uclass">请输入班级</label>
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
			<div class="insert-by-file-wrap">
				<form id="by-file-form" action="${pageContext.request.contextPath }/insertByExcelServlet" method="post">
					<input id="file-input" type="file" accept=".xls,.xlsx" />
					<input id="students-value" name="students" type="text"/>
					<label for="file-input" class="file-label iconfont">&#xe66c;使用Excel添加</label>
				</form>
				<div id="excel-data" class="file-result-wrap" v-show="students.length > 0 ">
					<ul class="users-ul">
						<li class="user-title-li">
							</span>
						<span class="user-title-span">姓名</span> <span
						class="user-title-span">手机号</span> <span class="user-title-span">性别</span>
						<span class="user-title-span">年龄</span> <span
						class="user-title-span">学院</span>
						<span
						class="user-title-span">班级</span>
						</li>
						<li class="user-item-li" v-for="(item, index) of students" :key="index">
							<span class="user-item-span">{{item.sname }}</span> <span
						class="user-item-span">{{item.sphone }}</span> <span
						class="user-item-span">{{item.ssex }}</span> <span
						class="user-item-span">{{item.sage }}</span> <span
						class="user-item-span">{{item.scollege }}</span> <span
						class="user-item-span">{{item.sclass }}</span>
						</li>
					</ul>
					<button type="button" id="file-insert-btn">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>