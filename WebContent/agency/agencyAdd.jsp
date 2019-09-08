<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>

<script type="text/javascript" src="../js/check.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>
<body>
	<form id="agencyForm" name="agency" method="post"
		action="../AgencyServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="agencyano" type="text" id="txtNum"
					onBlur="checkNum()"></td>
				<td><span id="tips_num">* 编号由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>用 户 名</td>
				<td><input name="agencyname" type="text" id="txtName"
					onBlur="checkName()"></td>
				<td><span id="tips_name">* 用户名由1-8位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码</td>
				<td><input name="password" type="password" id="txtPwd"
					onBlur="checkPassword()"></td>
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
					onclick="checkGender()">男 <input name="gender" type="radio"
					value="女" onclick="checkGender()">女</td>
				<td><span id="tips_gender">* 请选择您的性别</span></td>
			</tr>

			<tr>
				<td>手机号</td>
				<td><input name="phone" type="text" id="txtPhone"
					onBlur="checkPhone()"></td>
				<td><span id="tips_phone">* 请输入您的手机号</span></td>
			</tr>
			
			<tr>
				<td>备注</td>
				<td><textarea name="aremarks" cols="40" rows="5"
						id="txtRemarks" onblur="checkRemarks()"></textarea></td>
				<td><span id="tips_remarks">* 限100字以内</span></td>
			</tr>
			
			<tr>
				<td colspan="3" align="center"><input type="submit"
					name="submit" value="提交"> <input type="reset" name="reset"
					value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>