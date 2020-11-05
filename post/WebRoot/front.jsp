<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
请输入公告号(post_id):
<br>
<input type="text" id="post_id" name="post_id" value="">
<br>
<br>
<input type="button" value="删除" onclick="deleteValue();">
<input type="button" value="查询" onclick="queryValue();">
<input type="button" value="修改" onclick="window.location='modify_file.jsp'">
<input type="button" value="添加" onclick="window.location='add_file.jsp'">
<input type="button" name="listBtn" value="返回列表" onclick="window.location='record_list.jsp'">
    <br><div id="result"></div><br>
    <div id="result1"></div><br>
    <div id="result2"></div><br>
    <div id="result3"></div><br>
    <div id="result4"></div><br>

</body>
</html>

<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script>

    function deleteValue() {
        var postId=document.getElementById("post_id").value;
        var url="PostRemove?post_id="+postId;
        alert("删除成功");
        $.post(url)
      }
        
    function queryValue() {
        var postId=document.getElementById("post_id").value;
        var url="PostQuery?post_id="+postId;
        alert(url);
        $.post(url,function (data) {
            alert(data);
            var json=eval("("+data+")");
            var list=json.aaData;
            document.getElementById("result2").innerHTML=list[0].post_id;
            document.getElementById("result3").innerHTML=list[0].title;
            document.getElementById("result4").innerHTML=list[0].content;
        })
    }
</script>
