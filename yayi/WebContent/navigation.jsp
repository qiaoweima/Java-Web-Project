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
<body bgcolor="#00bdbd">
	<div id="choosediv">
		<ul class="chooseul" id="list">
			<li class="lis">
				<span id="choose1">更新管理预约</span>
				<ul>
					<li>
						<a href="client.jsp" target="right" id=ch1_1>修改预约</a>
					</li>
					<li>
						<a href="searchyy.jsp" target="right" id=ch1_2>查看预约</a>
					</li>
					<li>
						<a href="manage.jsp" target="right" id=ch1_2>接受预约</a>
					</li>
				</ul>
				
			</li>
			<li class="lis">
				<span id="choose2">用户管理</span>
				<ul>
					<li>
						<a href="userlist.jsp" target="right" id=ch2_1>权限管理</a>
					</li>
					<li>
						<a href="searchyh.jsp" target="right" id=ch2_1>查看用户</a>
					</li>
				</ul>
			</li>
			<li class="lis">
				<span href="" target="right" id="choose3">医生管理</span>
				<ul>
					<li>
						<a href="addtime.jsp" target="right" id=ch3_1>添加预约时间</a>
					</li>
					<li>
						<a href="searchdc.jsp" target="right" id=ch3_2>查看医生时间</a>
					</li>
					<li>
						<a href="doctorlist.jsp" target="right" id=ch3_2>删除医生时间</a>
					</li>
					
				</ul>
			</li>	
		</ul>
	</div>

	
</body>
</html>