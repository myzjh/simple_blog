<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>个性化设置</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/user-set.css">
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
<section class="user-set">
	<h2>个性化设置</h2>
	<form action="/blog/setting/update" method="post">
		<p><label>博客标题:</label><input type="text" name="blogName"/></p>
		<p><label>个性签名:</label><input type="text" name="idiograph"/></p>
		<input type="submit" name="" value="提交" id="set-sub">
	</form>
</section>
<!-- 侧边栏 -->
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<!-- 底部 -->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>