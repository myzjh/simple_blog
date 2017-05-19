<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty sessionScope.username}">
		<aside class="sidebar">
			<h2>页面导航</h2>
			<ul>
				<li><a href="/blog/index">博客首页</a></li>
				<li><a href="/blog/user/reg">新博客注册</a></li>
				<li><a href="/blog/user/loginPage">博客登录</a></li>
			</ul>
		</aside>
	</c:when>
	<c:otherwise>
		<aside class="sidebar">
			<h2>页面导航</h2>
			<ul>
				<li><a href="/blog/index">博客首页</a></li>
				<li><a href="/blog/user/home">用户首页</a></li>
				<li><a href="/blog/user/setting">个性化设置</a></li>
				<li><a href="/blog/article/addPage">写日志</a></li>
				<li><a href="/blog/p/show">相册</a></li>
				<li><a href="/blog/user/logout">退出</a></li>
			</ul>
		</aside>
	</c:otherwise>
</c:choose>