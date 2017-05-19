<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty sessionScope.username}">
		<div class="content">
			<img src="/blog/img/bg05.jpg">
			<h1>Hello word博客</h1>
			<nav class="nav">
				<ul>
					<li><a href="/blog/index">博客首页</a></li>
					<li><a href="/blog/user/reg">新博客注册</a></li>
					<li><a href="/blog/user/loginPage">博客登录</a></li>
				</ul>
			</nav>
		</div>
	</c:when>
	<c:otherwise>
		<div class="content">
			<img src="/blog/img/bg05.jpg">
			<h1>${empty sessionScope.setting.blogName?'Hello word博客':sessionScope.setting.blogName }</h1>
			<h5>${sessionScope.setting.idiograph }</h5>
			<nav class="nav">
			<ul>
				<li><a href="/blog/index">博客首页</a></li>
				<li><a href="/blog/user/home">用户首页</a></li>
				<li><a href="/blog/user/setting">个性化设置</a></li>
				<li><a href="/blog/article/addPage">写日志</a></li>
				<li><a href="/blog/p/show">相册</a></li>
				<li><a href="/blog/user/logout">退出</a></li>
			</ul>
			</nav>
		</div>
	</c:otherwise>
</c:choose>

