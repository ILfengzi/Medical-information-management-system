<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单添加</title>

<script type="text/javascript" src="../js/check.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>
<body>
	<form id="orderformForm" name="orderform" method="post"
		action="../OrderformServlet?method=add">
		<table align="center">
			<tr>
				<td>顾客编号</td>
				<td><input name="cno" type="text" id="txtCno"
					onBlur="checkCno()"></td>
				<td><span id="tips_cno">* 编号由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>经办人编号</td>
				<td><input name="ano" type="text" id="txtAno"
					onBlur="checkAno()"></td>
				<td><span id="tips_ano">* 用户名由1-12位字符组成</span>
				<td>
			</tr>

			<tr>
				<td>药品编号</td>
				<td><input name="mno" type="text" id="txtMno"
					onBlur="checkMno()"></td>
				<td><span id="tips_mno">* 用户名由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>症状</td>
				<td><textarea name="symptom" cols="40" rows="5"
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