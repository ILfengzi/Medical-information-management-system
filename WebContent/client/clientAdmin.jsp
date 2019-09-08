<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.bean.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客列表</title>

<link rel="stylesheet" href="../css/style.css" />

</head>
<body>
	<div align="center">
		<form action="../ClientServlet?method=find" method="post">
			<div id="search">
				查找方式：<select name="column">
					<option value="cno">编号</option>
					<option value="cname">姓名</option>
					<option value="cage">年龄</option>
					<option value="asex">性别</option>

				</select> 关键字：<input type="text" name="value" id="keyword" value="" /> <input
					type="submit" id="find" value="查询" /> &nbsp;&nbsp; <a
					href="clientAdd.jsp" target="main">添加顾客信息</a>
			</div>
		</form>
		<table border="1">

			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>住址</th>
				<th>手机号</th>
				<th>备注</th>
				<th>操作</th>
			</tr>

			<%
				for (Client c : (List<Client>) session.getAttribute("clientList")) {
					out.print("<tr><td>");
					out.print(c.getCno());
					out.print("<td>");
					out.print(c.getCname());
					out.print("<td>");
					out.print(c.getCsex());
					out.print("<td>");
					out.print(c.getCage());
					out.print("<td>");
					out.print(c.getCaddress());
					out.print("<td>");
					out.print(c.getCphone());
					out.print("<td>");
					out.print(c.getCremark());
					out.print("<td>");
					out.print("<a href='../ClientServlet?method=delete&name=" + c.getCno() + "'>删除</a>");
					out.print("&nbsp;");
					out.print("<a href='../ClientServlet?method=clientupdate&name=" + c.getCno() + "'>修改</a>");
					out.print("</td></tr>");
					
				}
			%>

		</table>
	</div>
</body>
</html>
