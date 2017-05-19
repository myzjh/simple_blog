<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>写日志</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/blog/css/comon.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/login-n.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/write.css">
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
	<!-- 富文本编辑器 -->
	<article class="write-here">
		<h3 class="add-log">添加文章</h3>
		<p><label for="log-tit">标题:</label><input type="text" name="title" id="log-tit" maxlength="50"/></p>
		<p>内容：</p>
			<!-- 加载编辑器的容器 -->
		    <script id="container" name="content" style="min-height:300px" type="text/plain"></script>
			<input type="button" name="" value="发表" id="submit"/>
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

		    	$("#submit").click(function(){
		    		var title = $("input[name='title']").val();
				    var article = {
						    "title":title,
						    "content":UE.getEditor('container').getContent()};
				    if(title == ''){
				    	alert("请填写标题！");
						return false;
					}
					
					 $.ajax({ 
				            type:"POST", 
				            url:"/blog/article/add", 
				            dataType:"json",      
				            contentType:"application/json",               
				            data:JSON.stringify(article), 
				            success:function(data){ 
				                  if(data.result=="nologin"){
										alert("请登录");
					              }else{
										location.href = "/blog/user/home";
						          }                    
				            } 
				         }); 
				});
  		</script>
</article>
<!-- 侧边栏 -->
	<jsp:include page="nav.jsp"></jsp:include>
</article>
<!-- 底部 -->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>