<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.util.Page"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>${empty user.nickname?user.username:user.nickname }的主页</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="/blog/css/index.css">
		<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
		<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
		<script type="text/javascript" src="/blog/js/jquery.min-3.0.0.js"></script>
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
		<article class="log">
			<section class="record" id="record">
				<!-- 文章列表 -->
				 <c:forEach var="article" items="${articles.list}" varStatus="index">
					<div class="list">
						<h3><a href="/blog/article/get/${article.id }">${article.title }</a></h3>
						<p><span>发表时间:</span><span><fmt:formatDate value="${article.ctime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
						<span>点击量: </span><span>1000</span>
						<span>评论数:</span><span>100</span></p>
						<a href="javascript:del(${article.id })">删除</a>
					</div>
			    </c:forEach>
				
			</section>
		<div class="num-list">
			<p>当前第<i id="num-now">${articles.currentPage }</i>页,共<i id="total-num">${articles.pageCount }</i>页,
				<a href="/blog/user/home/1">首页</a>
				<a href="/blog/user/home/${articles.currentPage-1 }">上一页</a>
				<a href="/blog/user/home/${articles.currentPage+1 }">下一页</a>
				<a href="/blog/user/home/${articles.pageCount }">尾页</a>
			</p>
		</div>
		</article>
			<jsp:include page="nav.jsp"></jsp:include>
		</article>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
  <script>
  	function del(id){
  	  	if(window.confirm("确定删除该文章吗？")){
	  	  	$.get("/blog/article/del/"+id,function(data){
				if(data=="error:0"){
					alert("删除成功！");
					location.href="/blog/user/home";
				}
			});
  	  	}else{
			return;
  	  	}
		
  	}
  </script>
</html>