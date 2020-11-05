<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*,java.io.*"%>
<html>
	<head>
		<title>添加公告</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		          公告ID
			<input type="text" id="post_id" name="post_id" value="">
			公告标题
			<input type="text" id="title" name="title" value="">
			<br>
			<br>
			公告内容
			<input type="text" id="content" name="content" value="">
			<input type="button" value="添加" onclick="addValue();">
			<input type="button" name="listBtn" value="返回列表" onclick="window.location='record_list.jsp'">

	</body>
</html>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script>

    function addValue() {
    	var postId=document.getElementById("post_id").value;
        var titleName=document.getElementById("title").value;
        var contentName=document.getElementById("content").value;
        var url="PostAdd?post_id="+postId+"&title="+titleName+"&content="+contentName;
        alert("添加成功");
        $.post(url)
      }
        
</script>
