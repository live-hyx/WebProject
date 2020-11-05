<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
请输入期货号(index_id):
<br>
<input type="text" id="index_id" name="index_id" value="">
<br>
<br>
<input type="button" value="删除" onclick="deleteValue();">
<input type="button" value="查询" onclick="queryValue();">
<input type="button" value="修改" onclick="window.location='modify_file.jsp'">
<input type="button" name="listBtn" value="返回列表" onclick="window.location='record_list.jsp'">
    <br><div id="result"></div><br>
    <div id="result1"></div><br>
    <div id="result2"></div><br>
    <div id="result3"></div><br>
    <div id="result4"></div><br>
    <div id="result5"></div><br>
    <div id="result6"></div><br>
    <div id="result7"></div><br>
    <div id="result8"></div><br>

</body>
</html>

<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script>

    function deleteValue() {
        var indexId=document.getElementById("index_id").value;
        var url="Remove?index_id="+indexId;
        alert("删除成功");
        $.post(url)
      }
        
    function queryValue() {
        var indexId=document.getElementById("index_id").value;
        var url="Query?index_id="+indexId;
        alert(url);
        $.post(url,function (data) {
            alert(data);
            var json=eval("("+data+")");
            var list=json.aaData;
            document.getElementById("result2").innerHTML=list[0].index_id;
            document.getElementById("result3").innerHTML=list[0].index_name;
            document.getElementById("result4").innerHTML=list[0].index_value;
            document.getElementById("result5").innerHTML=list[0].up_down;
            document.getElementById("result6").innerHTML=list[0].rise_fall;
            document.getElementById("result7").innerHTML=list[0].quantity;
            document.getElementById("result8").innerHTML=list[0].price;
        })
    }
</script>
