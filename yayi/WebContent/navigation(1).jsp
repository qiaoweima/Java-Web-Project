<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>导航页</title>
<link rel="stylesheet" type="text/css" href="css/navigation.css" />
<script type="text/javascript" src="js/navigation.js"></script>
</head>
<body bgcolor="#C4E1FF">
	<div id="choosediv">
		<ul class="chooseul" id="list">
			<li class="lis">
				<span id="choose1">更新管理预约</span>
				<ul>
					<li>
						<a href="temp.jsp" target="right" id=ch1_1>修改预约</a>
					</li>
					<li>
						<a href="temp.jsp" target="right" id=ch1_2>查看预约</a>
					</li>
				</ul>
				
			</li>
			<li class="lis">
				<span id="choose2">用户管理</span>
				<ul>
					<li>
						<a href="temp2.jsp" target="right" id=ch2_1>修改用户</a>
					</li>
					<li>
						<a href="temp2.jsp" target="right" id=ch2_1>查看用户</a>
					</li>
				</ul>
			</li>
			<li class="lis">
				<span href="temp.jsp" target="right" id="choose3">医生管理</span>
				<ul>
					<li>
						<a href="temp.jsp" target="right" id=ch3_1>添加预约时间</a>
					</li>
					<li>
						<a href="temp.jsp" target="right" id=ch3_2>查看医生时间</a>
					</li>
					
				</ul>
			</li>	
		</ul>
	</div>
	
</body>
</html>