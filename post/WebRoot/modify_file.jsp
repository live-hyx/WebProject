<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*,java.io.*"%>
<html>
	<head>
		<title>修改公告</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		
			公告标题
			<input type="text" id="title" name="title" value="">
			<br>
			<br>
			修改后公告内容
			<input type="text" id="modified_content_name" name="modified_content_name" value="">
			<input type="button" value="修改" onclick="modifyValue();">
			<input type="button" name="listBtn" value="返回列表" onclick="window.location='record_list.jsp'">

	</body>
</html>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script>

    function modifyValue() {
        var titleName=document.getElementById("title").value;
        var modify_contentName=document.getElementById("modified_content_name").value;
        var url="PostModify?modified_content_name="+modify_contentName+"&title="+titleName;
        alert("修改成功");
        $.post(url)
      }
        
</script>
