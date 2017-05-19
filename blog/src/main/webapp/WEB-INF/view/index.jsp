<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>博客首页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/index.css">
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
	<!-- 文章列表 -->
	 <c:forEach var="article" items="${articles.list}" varStatus="index">
		<div class="list">
			<h3><a href="/blog/article/get/${article.id }">${article.title }</a></h3>
			<p><span>发表时间:</span><span><fmt:formatDate value="${article.ctime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
			<span>点击量: </span><span>1000</span>
			<span>评论数:</span><span>100</span>
			<span>发表用户:</span><span>${article.username }</span></p>
		</div>
    </c:forEach>
	
	<div class="num-list">
		<p>当前第<i id="num-now">${articles.currentPage }</i>页,共<i id="total-num">${articles.pageCount }</i>页,
			<a href="/blog/index/1">首页</a>
			<a href="/blog/index/${articles.currentPage-1 }">上一页</a>
			<a href="/blog/index/${articles.currentPage+1 }">下一页</a>
			<a href="/blog/index/${articles.pageCount }">尾页</a>
		</p>
	</div>
	<!-- 侧边栏 -->
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>