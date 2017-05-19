<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>系统登陆页</title>
	<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
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
	<div class="login">
		<h2>博客登录</h2>
		<form action="/blog/user/login" method="post">
			<span>用户名：</span><input name="username" type="text" class="login-tex" placeholder="用户名"/><br>
			<span>密码：</span><input name="password" type="password" class="login-pa" placeholder="密码"/><br>
			<input type="submit" value="登录" class="login-su"/>
			<input type="button" value="注册" class="login-reg" onclick="javascript:location.href='/blog/user/reg'"/>
		</form>
	</div>
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>