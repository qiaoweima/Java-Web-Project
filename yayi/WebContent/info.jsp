<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remind</title>
     <script >
     
    window.onload=function(){
    	 var time;
    	 setTimeout(function(){
    		 alert('${text}');
            window.location.href='${urlpath}';
    	 },100);
    	
     }
     </script>
</head>
<body style="background:url(img/info.jpg) no-repeat; background-size:100%;">
     

</body>
</html>