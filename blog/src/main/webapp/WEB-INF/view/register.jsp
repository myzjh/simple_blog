<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>系统注册页</title>
	<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
<link rel="stylesheet" type="text/css" href="/blog/css/register.css">
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
<section class="reg-form">
<h3>新博客注册</h3>
	<form action="/blog/user/register" method="post">
		<div><span>呢  称:</span><input type="text" name="nickname" class="new-user new-inf"/><i>*</i></div><br>
		<div><span>用户名:</span><input type="text" name="username" class="new-user new-inf"/><i>*</i></div><br>
		<div><span>密 码:</span><input type="password" name="password" class="new-password new-inf"/><i>*</i></div><br>
		<!-- <div><span>确认密码:</span><input type="password" name="" class="new-password new-inf"/><i>*</i></div><br>
		<div><span>邮 箱:</span><input type="email" name="email" class="new-email new-inf"/><i>*</i></div><br> -->
		<div><span>密保问题:</span><input type="text" name="question" class="new-problem new-inf"/><i>*</i></div><br>
		<div><span>答 案:</span><input type="text" name="answer" class="new-answer new-inf"/><i>*</i></div><br>
		<div class="submit"><input type="submit" name="" value="提交" class="new-submit"/></div>
	</form>
</section>
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>