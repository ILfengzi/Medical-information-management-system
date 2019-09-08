<%@page import="com.util.DbcpPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>经办人信息修改</title>
<script type="text/javascript" src="./js/check.js"></script>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Agency agency = (Agency) request.getAttribute("agency");
	String agencyano = agency.getAno();
	System.out.print("agencyano:"+agencyano);
	String agencyname = agency.getAname();
	String password = agency.getApassword();
	String gender = agency.getAsex();
	String phone = agency.getAphone();
	String remarks = agency.getAremark();
%>
<body>
	<form id="agencyForm" name="agency" method="post"
		action="./AgencyServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="agencyano" type="text" id="txtAno"
					value="<%=agencyano%>" onfocus="this.blur()"></td>
				<td><span id="tips_agencyano"><em style='color: green'>
							*编号不可修改</em></span>
				<td>
			</tr>
		
			<tr>
				<td>用 户 名</td>
				<td><input name="agencyname" type="text" id="txtName"
					value="<%=agencyname%>" onBlur="return checkName()"></td>
				<td><span id="tips_agencyname">* 用户名由1-8位字符组成</span>
				<td>
			</tr>

			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码</td>
				<td><input name="password" type="password" id="txtPwd"
					onBlur="return checkPassword()"></td>
				<td><span id="tips_password">*
						密码由6-18位字符组成，且必须包含字母、数字和标点符号</span></td>
			</tr>

			<tr>
				<td>确认密码</td>
				<td><input name="pwdrepeat" type="password" id="txtRpt"
					onBlur="checkPwdrepeat()"></td>
				<td><span id="tips_pwdrepeat">* 请再次输入您的密码</span></td>
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
				<td>手机号</td>
				<td><input name="phone" type="text" id="txtPhone"
					value="<%=phone%>" onBlur="checkPhone()"></td>
				<td><span id="tips_phone">* 请输入您的手机号</span></td>
			</tr>

			<tr>
				<td>备注</td>
				<td><textarea name="aremarks" cols="40" rows="5"
						id="txtRemarks" onblur="return checkRemarks()"><%=remarks%></textarea></td>
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