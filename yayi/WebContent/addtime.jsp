<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="mybean.data.addtime"%>
<jsp:useBean id="addtime" class="mybean.data.addtime" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	overflow:hidden;
	background:#C4E1FF;
}
</style>
<script type="text/javascript">
function delcfm() {
    if (!confirm("确认要添加？")) {
        window.event.returnValue = false;
    }
}
function check(){
	//alert("yes");
	var input=document.getElementById("add").getElementsByTagName("input");
	if(input[0].value=="")
	{
			alert("姓名不能为空！");
			return false;
			
	}
	return true;
}
</script>
</head>
<body>
  	<form action="/yayi/addtime" method="post" id="add">
  	<span>添加医生在诊时间<br></span>
	  医生姓名<input type=text name="doctorname" value="" ><br>
	  在诊时间<input type=text name="time" value="" >
	  <input type=submit name="add" value="添加时间" onclick="check()">
	</form>
</body>
</html>