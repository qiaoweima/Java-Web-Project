<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="mybean.data.showdcSearch"%>
<jsp:useBean id="looks" class="mybean.data.showdcSearch" scope="request"/>
<jsp:setProperty name="looks" property="name"/>
<html>
<head>
<script type="text/javascript">

</script>
<style type="text/css">
body{
	overflow:hidden;
	background:#C4E1FF;
}
*{
  margin:0;
  padding:0;
}
 table.ta{
   width:80%;
   margin:100px auto 200px;
   font-family:verdana,arial,snas-serif;
   font-size:11px;
   color:#333333;
   border-width:1px;
   border-color:#666666;
   border-collapse:collapse;
 }
 table.ta th{
   border-width:1px;
   padding:8px;
   border-style:solid;
   broder-color:#666666;
   background-color:#dedede;
 }
 table.ta td{
   border-width:1px;
   padding:8px;
   border-style:solid;
   border-color:#666666;
   background-color:#ffffff;
 }
 .tableCenter{
   text-align:center;
   position:absolute;
   width:100%;
   height:100px;
   z-index:999;
 }
 table.change{
   <!--
   position:relative;
   top:-200px;
   left:580px;
   -->
   position:absolute;
   margin:-200px auto;
 }
 #add{
 	margin-top:50px;
 	position:relative;
 	left:-200px;
 }
 </style>
  <script type="text/javascript">
 function delcfm() {
     if (!confirm("确认要删除？")) {
         window.event.returnValue = false;
     }
 }
 function checkjs() {
     alert("接受预约成功");
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
 <div id="d1">
  <div class = "tableCenter">
  	<form action="" method="post" id="add" style="display:inline-block;margin-left:350px;">
  	<span>查询列表<br></span>
	  医生姓名<input type=text name="name" value="" >
	  <input type=submit name="add" value="查询" onclick="return check()">
	</form>
	<form action="" id="all" style="position:relative;top:0;left:0;">
	<input type=hidden name="" value="all">
	<input type=submit name="" value="展示全部" style="position:relative;top:-20px;left:150px;">
	</form>
	 <jsp:setProperty name="looks" property="pageSize" value="5"/>
	  <jsp:setProperty name="looks" property="showPage"/>
  <jsp:getProperty name="looks" property="presentPageResult"/>
  <br>
  <table class="change">
   <tr>
    <td>
     <form action="">
	  <input type=hidden name="showPage" value="<%=looks.getShowPage()-1%>">
	  <input type=submit name="" value="上一页">
	 </form>
    </td>
	<td>
	 <form action="">
	  <input type=hidden name="showPage" value="<%=looks.getShowPage()+1%>">
	  <input type=submit name="" value="下一页">
	 </form>
	</td>

   </tr>
  </table>
  </div>
 </div>
 </body>
</html>
