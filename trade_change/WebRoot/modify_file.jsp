<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*,java.io.*"%>
<html>
	<head>
		<title>修改设备</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		
			期货ID
			<input type="text" id="index_id" name="index_id" value="">
			<br>
			<br>
			修改后期货名称
			<input type="text" id="modified_index_name" name="modified_index_name" value="">
			<input type="button" value="修改" onclick="modifyValue();">
			<input type="button" name="listBtn" value="返回列表" onclick="window.location='record_list.jsp'">

	</body>
</html>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script>

    function modifyValue() {
        var indexId=document.getElementById("index_id").value;
        var modify_indexName=document.getElementById("modified_index_name").value;
        var url="Modify?modified_index_name="+modify_indexName+"&index_id="+indexId;
        alert("修改成功");
        $.post(url)
      }
        
</script>
