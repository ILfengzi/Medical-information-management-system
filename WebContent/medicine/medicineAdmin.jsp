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
		<form action="../MedicineServlet?method=find" method="post">
			<div id="search">
				查找方式：<select name="column">
					<option value="mno">编号</option>
					<option value="mname">药品名称</option>
					<option value="mmode">服用方法</option>
					<option value="mefficacy">功效</option>

				</select> 关键字：<input type="text" name="value" id="keyword" value="" /> <input
					type="submit" id="find" value="查询" /> &nbsp;&nbsp; <a
					href="medicineAdd.jsp" target="main">添加药品信息</a>
			</div>
		</form>
		<table border="1">

			<tr>
				<th>编号</th>
				<th>药品名称</th>
				<th>服用方法</th>
				<th>功效</th>
				<th>操作</th>
			</tr>

			<%
				for (Medicine m : (List<Medicine>) session.getAttribute("medicineList")) {
					out.print("<tr><td>");
					out.print(m.getMno());
					out.print("<td>");
					out.print(m.getMname());
					out.print("<td>");
					out.print(m.getMmode());
					out.print("<td>");
					out.print(m.getMefficacy());
					out.print("<td>");
					out.print("<a href='../MedicineServlet?method=delete&name=" + m.getMno() + "'>删除</a>");
					out.print("&nbsp;");
					out.print("<a href='../MedicineServlet?method=medicineupdate&name=" + m.getMno() + "'>修改</a>");
					out.print("</td></tr>");
					
				}
			%>

		</table>
	</div>
</body>
</html>
