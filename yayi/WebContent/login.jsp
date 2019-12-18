<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>牙科诊所登录</title>
	<link rel="stylesheet" href="css/p.css" />
	<script type="text/javascript">
            function isValid (form){
            	if (form.username.value==""){ 
            	   alert("账号不能为空！");
            	   return false;	
                }
                if (form.password.value ==""){
                   alert ("密码不能为空！");
                   return false;
                }
                return true;
            }
    </script>
</head>
<body>
    
    <div class="background">
       <div class="top">欢迎使用本牙科诊所预约管理系统</div> 
    
       <div class="p">  
           <div class="lable">用户登录</div>
           <div class="p1">
           <form action="/yayi/login" method="post" onSubmit="return isValid(this);">
		         <div style="margin:15px;"> 
		              <font color="black" style="font-size: 15px ;">账号：</font> 
				      <input type="text" id="username" name="username" placeholder="请输入账号" style="height:20px;width:200px;border-radius: 5px;">
				 </div> 
				 <div style="margin-left:15px;margin-top:15px;margin-bottom:5px"> 
					  <font color="black" style="font-size: 15px ;">密码：</font>
					  <input type="password" id="password" name="password" placeholder="请输入密码" style="height:20px;width:200px;border-radius: 5px;">
				 </div>
				<div style="margin-left:80px;">
                      <input type="radio" id="user" name="radio-enter" checked="checked" value="user">
                      <label for="user">用户&nbsp;&nbsp;</label>
	                  <input type="radio" id="manager" name="radio-enter" value="manager">
                      <label for="manager">管理员</label>
                 </div>
				 <div style="margin-top:10px;margin-left:120px;"> 
					  <input id="btn-login" class="btn" type="submit" value="登录"  style="height:30px;width:60px;border-radius: 5px;">
			     </div>
			     <div style="margin-top:5px;margin-left:90px;"> 
					  <font color="black" style="font-size: 15px ;">还没注册账号？</font>
					  <a href="register.jsp" >注册</a>
				 </div>
	      </form>
	      </div>
          </div>
    </div>
    
</body>
</html>