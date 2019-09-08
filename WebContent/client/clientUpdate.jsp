<%@page import="com.util.DbcpPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客信息修改</title>
<script type="text/javascript" src="./js/check.js"></script>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Client client = (Client) request.getAttribute("client");
	String clientcno = client.getCno();
	System.out.print("agencyano:"+clientcno);
	String clientname = client.getCname();
	String gender = client.getCsex();
	String cage = client.getCage();
	String caddress = client.getCaddress();
	String phone = client.getCphone();
	String cremark = client.getCremark();
%>
<body>
	<form id="clientForm" name="client" method="post"
		action="./ClientServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="clientcno" type="text" id="txtNum"
					value="<%=clientcno%>" onfocus="this.blur()"></td>
				<td><span id="tips_num"><em style='color: green'>
							*编号不可修改</em></span>
				<td>
			</tr>
			
			<tr>
				<td>用 户 名</td>
				<td><input name="clientname" type="text" id="txtName"
					value="<%=clientname%>" onBlur="return checkName()"></td>
				<td><span id="tips_name">* 用户名由1-8位字符组成</span>
				<td>
			</tr>

			<tr>
				<td>性&nbsp;&nbsp;&nbsp;别</td>
				<td><input name="gender" type="radio" value="男"
					<%if (gender.equals("男"))
				out.print("checked='true'");%>
					onClick="return checkGender()" />男 <input name="gender" type="radio"
					value="女"
					<%if (gender.equals("女"))
				out.print("checked='true'");%>
					onClick="return checkGender()" />女</td>
				<td><span id="tips_gender">* 请选择您的性别</span></td>
			</tr>
			
			<tr>
				<td>年龄</td>
				<td><input name="cage" type="text" id="txtCage"
					value="<%=cage%>" onBlur="return checkCage()"></td>
				<td><span id="tips_cage">* 请输入顾客的年龄</span></td>
			</tr>
			
			<tr>
				<td>住址</td>
				<td><input name="caddress" type="text" id="txtAddress"
					value="<%=caddress%>" onBlur="return checkAddress()"></td>
				<td><span id="tips_address">* 请输入顾客的住址</span></td>
			</tr>
			
			<tr>
				<td>手机号</td>
				<td><input name="phone" type="text" id="txtPhone"
					value="<%=phone%>" onBlur="checkPhone()"></td>
				<td><span id="tips_phone">* 请输入您的手机号</span></td>
			</tr>

			<tr>
				<td>备注</td>
				<td><textarea name="cremark" cols="40" rows="5"
						id="txtRemarks" onblur="return checkRemarks()"><%=cremark%></textarea></td>
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