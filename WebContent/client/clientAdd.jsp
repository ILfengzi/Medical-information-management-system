<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客注册</title>

<script type="text/javascript" src="../js/check.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>
<body>
	<form id="clientForm" name="client" method="post"
		action="../ClientServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="clientcno" type="text" id="txtNum"
					onBlur="checkNum()"></td>
				<td><span id="tips_num">* 编号由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>用 户 名</td>
				<td><input name="clientname" type="text" id="txtName"
					onBlur="checkName()"></td>
				<td><span id="tips_name">* 用户名由1-8位字符组成</span>
				<td>
			</tr>

			<tr>
				<td>性&nbsp;&nbsp;&nbsp;别</td>
				<td><input name="gender" type="radio" value="男"
					onclick="checkGender()">男 <input name="gender" type="radio"
					value="女" onclick="checkGender()">女</td>
				<td><span id="tips_gender">* 请选择顾客的性别</span></td>
			</tr>

			<tr>
				<td>年龄</td>
				<td><input name="cage" type="text" id="txtCage"
					onBlur="checkCage()"></td>
				<td><span id="tips_cage">* 请输入顾客的年龄</span></td>
			</tr>
			
			<tr>
				<td>住址</td>
				<td><input name="caddress" type="text" id="txtAddress"
					onBlur="checkAddress()"></td>
				<td><span id="tips_address">* 请输入顾客的住址</span></td>
			</tr>
			
			<tr>		
				<td>手机号</td>
				<td><input name="phone" type="text" id="txtPhone"
					onBlur="checkPhone()"></td>
				<td><span id="tips_phone">* 请输入您的手机号</span></td>
			</tr>
		
			<tr>
				<td>备注</td>
				<td><textarea name="cremark" cols="40" rows="5"
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