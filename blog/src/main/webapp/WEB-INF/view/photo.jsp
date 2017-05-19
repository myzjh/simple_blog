<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>上传图片</title>
	<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/comon.css">
<link rel="stylesheet" type="text/css" href="../css/login-n.css">
<link rel="stylesheet" type="text/css" href="../css/photo.css">

</head>
<body>
<header class="header">
	<jsp:include page="head.jsp"></jsp:include>
</header>
<article class="main">
	<div class="search">
		<form action="" method="">
			<input type="text" class="search-tex">
			<input type="submit" value="search" class="search-bot">
		</form>
	</div>
<section class="add-photo">
	<h2>上传图片</h2>
	<form action="/blog/p/upload" method="post" enctype="multipart/form-data">
		<label>选择要上传的图片:</label><input type="file" name="file"/><br>
		<input type="submit" name="" value="上传" id="upload">
	</form>
	<h2>显示相册图片</h2>
	<div class="show-photo">
		<ul>
		<c:forEach items="${photos}" var="photo">
			<li><img src="${photo.uri }"></li>
		</c:forEach>
			
		</ul>
	</div>
</section>
<!-- 侧边栏 -->
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<!-- 底部 -->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>