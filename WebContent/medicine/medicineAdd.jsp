<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品添加</title>

<script type="text/javascript" src="../js/check.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>
<body>
	<form id="medicineForm" name="medicine" method="post"
		action="../MedicineServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="medicinemno" type="text" id="txtNum"
					onBlur="checkNum()"></td>
				<td><span id="tips_num">* 编号由1-12位字符组成</span>
				<td>
			</tr>
			
			<tr>
				<td>药品名称</td>
				<td><input name="medicinename" type="text" id="txtMedicinename"
					onBlur="Medicinename()"></td>
				<td><span id="tips_medicinename">* 请填写药品名称</span>
				<td>
			</tr>

			<tr>
				<td>服用方法</td>
				<td><input name="mmode" type="radio" value="内服"
					onclick="checkMode()">男 <input name="mmode" type="radio"
					value="外用" onclick="checkMode()">女</td>
				<td><span id="tips_mmode">* 请选择服用方法</span></td>
			</tr>

			<tr>
				<td>功效</td>
				<td><textarea name="mefficacy" cols="40" rows="5"
						id="txtMefficacy" onblur="checkMefficacy()"></textarea></td>
				<td><span id="tips_mefficacy">* 请填写药品功效</span></td>
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