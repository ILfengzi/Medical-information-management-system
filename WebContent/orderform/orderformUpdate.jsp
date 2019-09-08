<%@page import="com.util.DbcpPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.text.DateFormat, java.util.*,com.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单信息修改</title>
<script type="text/javascript" src="./js/check.js"></script>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Orderform orderform = (Orderform) request.getAttribute("orderform");
	int ono = orderform.getOno();
	System.out.print("ono:"+orderform);
	String cno = orderform.getCno();
	String ano = orderform.getAno();
	String mno = orderform.getMno();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = df.format(orderform.getDate());
	String symptom = orderform.getSymptom();
%>
<body>
	<form id="orderformForm" name="orderform" method="post"
		action="./OrderformServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="ono" type="text" id="txtNum"
					value="<%=ono%>" onfocus="this.blur()"></td>
				<td><span id="tips_num"><em style='color: green'>
							*编号不可修改</em></span>
				<td>
			</tr>
			
			<tr>
				<td>顾客编号</td>
				<td><input name="cno" type="text" id="txtCno"
					value="<%=cno%>" onBlur="checkCno()"></td>
				<td><span id="tips_cno">* 编号由1-12位字符组成</span>
				<td>
			</tr>

			<tr>
				<td>经办人编号</td>
				<td><input name="ano" type="text" id="txtAno"
					value="<%=ano%>" onBlur="checkAno()"></td>
				<td><span id="tips_ano">* 用户名由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>药品编号</td>
				<td><input name="mno" type="text" id="txtMno"
					value="<%=mno%>" onBlur="checkMno()"></td>
				<td><span id="tips_mno">* 用户名由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>日期</td>
				<td><input name="date" type="text" id="txtDate"
					value="<%=date%>" onfocus="this.blur()"></td>
				<td><span id="tips_date"><em style='color: green'>
							*日期不可修改</em></span>
				<td>
			</tr>
			
			<tr>
				<td>症状</td>
				<td><textarea name="symptom" cols="40" rows="5"
						id="txtRemarks" onblur="checkRemarks()"><%=symptom%></textarea></td>
				<td><span id="tips_remarks">* 限100字以内</span></td>
			</tr>

			<tr>
				<td colspan="3" align="center"><input type="submit"
					name="submit" value="提交" /> <input type="reset" name="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>