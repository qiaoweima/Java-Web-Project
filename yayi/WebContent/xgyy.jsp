<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mybean.data.findradio" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/xgyy.css"/>
		<script>
			window.onload=function(){
				var tcc=document.getElementById("tccontent");
				var tc=document.getElementById("tanchuang");
				var input=document.getElementsByTagName("input");
				//var close=document.getElementById("close");
				var sex=document.getElementById("sex");
				var close=document.getElementsByTagName("button");
				var time=document.getElementsByClassName("time");
				var doctorname=document.getElementsByClassName("doctorname");
				var p=tc.getElementsByTagName("span");
				//alert(doctorname[0].value);
				//p.style.display="block";
				var onoff=false;
				var flag=null;
				var find;
				click(5);
				input[5].style.background="white";
				if(sex.value=="女"){
					input[2].checked=false;
					input[3].checked=true;
				}
				input[4].onclick=function(){
					tc.style.display="block";
					input[5].value="请选择";
					if(flag!=4&&flag)
					{
						var children=tcc.getElementsByTagName("label");
						var bchildren=tcc.getElementsByTagName("br");
						var k=children.length;
						//alert(bchildren.length);
						for(j=children.length-1;j>=0;j--){
								tcc.removeChild(children[j]);
								tcc.removeChild(bchildren[j+1]);
								//alert(j);
							}	
						//alert(bchildren.length);
						onoff=false;
					}
						add="医生选择<br>";
						flag=4;
						p[0].innerHTML=add;
						if(onoff==false){
							
							for(var q=0;q<doctorname.length;q++)
							{
								var c=document.createElement("input");
								var l=document.createElement("label");
								var b=document.createElement("br");
								l.innerHTML=doctorname[q].value;
								c.type="radio";
								c.name="doctor";
								l.appendChild(c);
								c.value=doctorname[q].value;
								tcc.appendChild(l);
								tcc.appendChild(b);
								//alert(c);
								//tcc.innerHTML+=c+"";
							}
							onoff=true;
						}
				}
				close[1].onclick=function(){
					tc.style.display="none";
					var radio=tcc.getElementsByTagName("input");
					//alert(input[5].value);
					for(var i=0;i<radio.length;i++)
						{
							if(radio[i].checked)
								{
									find=i;
									break;
								}
						}
					//alert(radio[0].name);
					if(radio[find].name=="doctor")
						{
							input[4].value=radio[find].value;
							input[5].value="请选择";
						}
					if(radio[find].name=="time")
						{input[5].value=radio[find].value;}
					//radio[find].checked=false;
					if(input[4].value!="请选择")
						{
						input[5].style.background="white";
							click(5);
						//alert(input[4].value);
						}
						find=null;
				}
				
				function click(i){
					input[5].onclick=function(){
						tc.style.display="block";
						this.value="请选择";
						//alert(children[5]);
						var add;
						//alert(1);
						if(flag!=5&&flag)
							{
								var children=tcc.getElementsByTagName("label");
								var bchildren=tcc.getElementsByTagName("br");
								var k=children.length;
								//alert(bchildren.length);
								for(j=children.length-1;j>=0;j--){
										tcc.removeChild(children[j]);
										tcc.removeChild(bchildren[j+1]);
										//alert(j);
									}	
								//alert(bchildren.length);
								onoff=false;
							}
							add="预约时间选择<br>";
							flag=5;
							
						p[0].innerHTML=add;
						
						if(onoff==false){
							for(var q=0;q<time.length;q++)
							{
								if(time[q].getAttribute("data")==input[4].value){
								var c=document.createElement("input");
								var l=document.createElement("label");
								var b=document.createElement("br");
								l.innerHTML=time[q].value;
								c.type="radio";
								c.name="time";
								l.appendChild(c);
								c.value=time[q].value;
								//alert(time[q].getAttribute("data"));
								tcc.appendChild(l);
								tcc.appendChild(b);
								}
							}
							onoff=true;
							}
						}
				}
				
			}
		</script>
		<script type="text/javascript">
		function check(){
			//alert("yes");
			var input=document.getElementsByTagName("input");
			if(input[0].value=="")
			{
					alert("姓名不能为空！");
					return false;
					
			}
			if(input[1].value=="")
			{
				alert("年龄不能为空！");
				return false;
				
			}
			if(input[4].value=="请选择")
			{
				alert("医生不能为空！");
				return false;
				
			}
			if(input[5].value=="请选择")
			{
				alert("预约时间不能为空！");
				return false;
			}
			alert("修改成功");
			return true
		}
		</script>
</head>
<body>
<body>
		<div id="content"><p>预约信息表</p>
		<form method="post" action="/yayi/updata">
			&emsp;&emsp;姓名：  <input type="text" name="name" value="${xinxi[0].姓名}" placeholder="请输入姓名"/><br>
			&emsp;&emsp;年龄：  <input type="text" name="age" value="${xinxi[0].年龄}" placeholder="请输入年龄"/><br>
			&emsp;&emsp;性别：  男<input type="radio" name="sex" checked="checked" value="男"/>&emsp;&emsp;女<input type="radio" name="sex" value="女"/><br>
			&emsp;&emsp;医生：  <input type="text" name="doctor" readonly="readonly" id="doctor" value="${xinxi[0].预约医生}"/><br>   
			 预约时间：<input name="time" readonly="readonly" id="time" value="${xinxi[0].预约时间}"/><br>
			&emsp;&emsp; <p>备注：</p><textarea name="beizhu">${xinxi[0].备注}</textarea><br>
			<input id="submit" type="submit" value="提交预约" name="submit" onclick="return check()"/>
			<input id="sex" id="hidden" type="hidden" value="${xinxi[0].性别}" />
			<input id="olddoctor" type="hidden" name="olddoctor" value="${xinxi[0].预约医生}" />
			<input id="oldname" type="hidden" name="oldname" value="${xinxi[0].姓名}" />
			<input id="oldtime" type="hidden" name="oldtime" value="${xinxi[0].预约时间}" />
			<c:forEach items="${name}" var="name">
			<input class="doctorname" id="hidden" type="hidden" value="${name.医生姓名 }" />
			</c:forEach>
			<c:forEach items="${findtime}" var="findtime">
			<input class="time" id="hidden" type="hidden" value="${findtime.在诊时间 }" data="${findtime.医生姓名 }" />
			</c:forEach>
			<button id="back">返回</button>
		</form>
		</div>		
		<div id="tanchuang">
			<div id="tccontent">
			<span>1<br></span>
				<button id="close">关闭</button>
			</div>
			
		</div>
	</body>
</body>
</html>