<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.text.DateFormat, java.util.*,com.bean.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>订单列表</title>

<link rel="stylesheet" href="../css/style.css" />

</head>
<body>
	<div align="center">
		<form action="../OrderformServlet?method=find" method="post">
			<div id="search">
				查找方式：<select name="column">
					<option value="cno">顾客编号</option>
					<option value="ano">经办人编号</option>
					<option value="mno">药品编号</option>
					<option value="symptom">症状</option>
					<option value="date">日期</option>

				</select> 关键字：<input type="text" name="value" id="keyword" value="" /> <input
					type="submit" id="find" value="查询" /> &nbsp;&nbsp; <a
					href="orderformAdd.jsp" target="main"><button><em style='color: red'>下单</em></button></a>
			</div>
		</form>
		<table border="1">

			<tr>
				<th>编号</th>
				<th>顾客编号</th>
				<th>经办人编号</th>
				<th>药品编号</th>
				<th>日期</th>
				<th>症状</th>
				<th>操作</th>
			</tr>

			<%
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (Orderform o : (List<Orderform>) session.getAttribute("orderformList")) {
					out.print("<tr><td>");
					out.print(o.getOno());
					out.print("<td>");
					out.print(o.getCno());
					out.print("<td>");
					out.print(o.getAno());
					out.print("<td>");
					out.print(o.getMno());
					out.print("<td>");
					out.print(df.format(o.getDate()));
					out.print("<td>");
					out.print(o.getSymptom());
					out.print("<td>");
					out.print("<a href='../OrderformServlet?method=delete&name=" + o.getOno() + "'>删除</a>");
					out.print("&nbsp;");
					out.print("<a href='../OrderformServlet?method=orderformupdate&name=" + o.getOno() + "'>修改</a>");
					out.print("</td></tr>");
					
				}
			%>

		</table>
	</div>
</body>
</html>
