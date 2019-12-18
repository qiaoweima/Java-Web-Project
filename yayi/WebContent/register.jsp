<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>注册页面</title>
   <link rel="stylesheet" href="css/p.css" />
   <script type="text/javascript">
            function next(){
                window.location = "login.jsp";
            }
            function isValid (form){
            	if (form.username.value==""){ 
            	   alert("账号不能为空！");
            	   return false;	
                }
                if (form.password.value ==""){
                   alert ("密码不能为空！");
                   return false;
                }
                if (form.password1.value ==""){
                    alert ("请再次输入密码！");
                    return false;
            	}
                if (form.password.value !=form.password1.value ){
                    alert ("两次输入的密码不同！");
                    return false;
                 }
                return true;
            }
   </script>
   
</head>
<body>

     <div class="background1">
        <div class="all">
           <div class="lable">新用户注册</div>
           <div class="p1">
         <!--    <form action="checkRegister.jsp" method="post" onSubmit="return isValid(this);">  -->
                 <form action="/yayi/register" method="post" onSubmit="return isValid(this);">
		         <div style="margin:16px;"> 
		              <font color="gray" style="font-size: 15px ;">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</font> 
				      <input type="text" id="username" name="username" placeholder="请输入账号" style="height:20px;width:180px;border-radius: 5px;">
				 </div> 
				 <div style="margin:16px;"> 
					  <font color="gray" style="font-size: 15px ;">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</font>
					  <input type="password" id="password" name="password" placeholder="请输入密码" style="height:20px;width:180px;border-radius: 5px;">
				 </div>
				 <div style="margin-left:12px;"> 
					  <font color="gray" style="font-size: 15px ;">确认密码：</font>
					  <input type="password" id="password1" name="password1" placeholder="请再次输入密码" style="height:20px;width:180px;border-radius: 5px;">
				 </div>
				 <div style="margin-top:25px;margin-left:60px;"> 
					  <input id="btn-register" class="btn" type="submit" value="注册"  style="height:30px;width:60px;border-radius: 5px;">
					  <input type="reset" value="重置" style="height:30px;width:60px;border-radius: 5px;">
					  <input id="btn-register1" class="btn" type="button" value="返回" onclick="next()" style="height:30px;width:60px;border-radius: 5px;">
				 </div>
	        </form>
	      </div>
        </div>
     </div>

</body>
</html>