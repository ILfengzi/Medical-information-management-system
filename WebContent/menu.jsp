<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>导航栏</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body id="body2">
	<div align="center">
	<p class="p1">系统导航</p>
	<p><a href="AgencyServlet?method=find" target="main">经办人管理</a></p>
	<p><a href="ClientServlet?method=find" target="main">顾客管理</a></p>
	<p><a href="MedicineServlet?method=find" target="main">药品管理</a></p>
	<p><a href="OrderformServlet?method=find" target="main">订单管理</a></p>
	</div>
</body>
</html>