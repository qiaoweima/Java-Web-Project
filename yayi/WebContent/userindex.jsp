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
<body bgcolor="#009fec">
	<div id="choosediv">
		<ul class="chooseul" id="list">
			<li class="lis">
				<span id="choose1">预约医生</span>
				<ul>
					<li>
						<a href="/yayi/zxyy" target="right" id=ch1_1>在线预约</a>
					</li>
					<li>
						<a href="/yayi/sershowme" target="right" id=ch1_2>我的预约</a>
					</li>
					<li>
						<a href="/yayi/changeme" target="right" id=ch1_2>修改预约</a>
					</li>
				</ul>
				
			</li>
			<li class="lis">
				<span id="choose2">查看医生</span>
				<ul>
					<li>
						<a href="searchdc.jsp" target="right" id=ch2_1>医生工作表</a>
					</li>

				</ul>
			</li>
		</ul>
	</div>

	
</body>
</html>