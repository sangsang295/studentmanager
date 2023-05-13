<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nav</title>
<link rel="stylesheet" href="./css/nav.css" />
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>

	<div id="nav">
		<ul >
			<li class="list-li" v-for="(item, index) of lists" :key="index">
				<a class="list-a active" :href="item.href" v-if="${!empty param.active } && ${param.active } == index">{{item.title}}</a> 
				<a class="list-a" :href="item.href" v-else>{{item.title}}</a>
			</li>
		</ul>
	</div>
</body>
</html>