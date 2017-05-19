<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>文章评论页</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
		<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
		<link rel="stylesheet" type="text/css" href="/blog/css/editor.css">
		<script type="text/javascript" src="/blog/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="/blog/ueditor/ueditor.all.min.js"> </script>
		<script type="text/javascript" src="/blog/ueditor/lang/zh-cn/zh-cn.js"></script>
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
				<input type="hidden" name="aid" value="${article.id }"/>
				<h2>${article.title }</h2>
				<br/>
				<div>${article.content }</div>
				<div>
					<br/>
					<span>${article.username }|<fmt:formatDate value="${article.ctime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
				</div>
				<c:forEach var="comment" items="${comments}">
					<div class="line">
						<p>${comment.content }</p>
						<br/>
					<span>${comment.username }|<fmt:formatDate value="${comment.ctime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
				</div>
				</c:forEach>
				
			</section>
			<section class="editor">
				<span class="tit">发表评论</span>
				<!-- 加载编辑器的容器 -->
				<script id="container" name="content" type="text/plain"></script>
				<button id="submit">发表</button>
				<!-- 实例化编辑器 -->
				<script type="text/javascript">
			        var ue = UE.getEditor('container',{
			        	toolbars: [
						    ['fullscreen', 'source', 'undo', 'redo'],
						    ['bold', 'italic', 'underline', '|', 'forecolor', 'backcolor', 'insertorderedlist',
						      'insertunorderedlist', '|',
						     'paragraph', 'fontfamily', 'fontsize', '|',
						     'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 
						     'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
						     'simpleupload', 'insertimage', 'emotion', 'scrawl']
						]});
			        ue.ready(function(){
					    //设置编辑器的内容
					    //ue.setContent('hello');
					    //获取html内容，返回: <p>hello</p>
					    var html = ue.getContent();
					    //获取纯文本内容，返回: hello
					    var txt = ue.getContentTxt();
			        });
			        
				    $("#submit").click(function(){
					    var aid = $("input[name='aid']").val();
					    var comment = {"aid":aid,"content":UE.getEditor('container').getContent()};
						//alert(UE.getEditor('container').getContent());
						//return;
						 $.ajax({ 
					            type:"POST", 
					            url:"/blog/comment/say", 
					            dataType:"json",      
					            contentType:"application/json",               
					            data:JSON.stringify(comment), 
					            success:function(data){ 
					                  if(data.result=="nologin"){
											alert("请登录");
						              }else{
											location.reload();
							          }                    
					            } 
					         }); 
					});
					//});
		  		</script>
			</section>

		</article>
			<jsp:include page="nav.jsp"></jsp:include>
		</article>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>