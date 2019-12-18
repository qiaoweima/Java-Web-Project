<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="mybean.data.showRecord"%>
<jsp:useBean id="looka" class="mybean.data.showRecord" scope="session"/>
<jsp:setProperty name="looka" property="pageSize" value="5"/>
<html>
<head>
<script type="text/javascript">

</script>
<style type="text/css">
*{
  margin:0;
  padding:0;
}
body{
	overflow:hidden;
	background:#C4E1FF;
}
 table.ta{
   width:80%;
   margin:150px auto 200px;
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
 </style>
</head>
 <body> 
 <div id="d1">
  <div class = "tableCenter">
  <jsp:setProperty name="looka" property="showPage"/>
  <jsp:getProperty name="looka" property="presentPageResult"/>
  <br>
  <table class="change">
   <tr>
    <td>
     <form action="">
	  <input type=hidden name="showPage" value="<%=looka.getShowPage()-1%>">
	  <input type=submit name="" value="上一页">
	 </form>
    </td>
	<td>
	 <form action="">
	  <input type=hidden name="showPage" value="<%=looka.getShowPage()+1%>">
	  <input type=submit name="" value="下一页">
	 </form>
	</td>
   </tr>
  </table>
  </div>
 </div>
 </body>
</html>
