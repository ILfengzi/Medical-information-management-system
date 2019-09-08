<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.bean.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>经办人列表</title>

<link rel="stylesheet" href="../css/style.css" />

</head>
<body>
	<div align="center">
		<form action="../AgencyServlet?method=find" method="post">
			<div id="search">
				查找方式：<select name="column">
					<option value="ano">编号</option>
					<option value="aname">姓名</option>
					<option value="asex">性别</option>

				</select> 关键字：<input type="text" name="value" id="keyword" value="" /> <input
					type="submit" id="find" value="查询" /> &nbsp;&nbsp; <a
					href="agencyAdd.jsp" target="main">添加经办人</a>
			</div>
		</form>
		<table border="1">

			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>手机号</th>
				<th>备注</th>
				<th>操作</th>
			</tr>

			<%
				for (Agency a : (List<Agency>) session.getAttribute("agencyList")) {
					out.print("<tr><td>");
					out.print(a.getAno());
					out.print("<td>");
					out.print(a.getAname());
					out.print("<td>");
					out.print(a.getAsex());
					out.print("<td>");
					out.print(a.getAphone());
					out.print("<td>");
					out.print(a.getAremark());
					out.print("<td>");
					out.print("<a href='../AgencyServlet?method=delete&name=" + a.getAno() + "'>删除</a>");
					out.print("&nbsp;");
					out.print("<a href='../AgencyServlet?method=agencyupdate&name=" + a.getAno() + "'>修改</a>");
					out.print("</td></tr>");
				System.out.print("春江花月夜");
				}
			%>

		</table>
	</div>
</body>
</html>
