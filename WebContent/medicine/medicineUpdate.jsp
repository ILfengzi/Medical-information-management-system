<%@page import="com.util.DbcpPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品信息修改</title>
<script type="text/javascript" src="./js/check.js"></script>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Medicine medicine = (Medicine) request.getAttribute("medicine");
	String medicinemno = medicine.getMno();
	System.out.print("agencyano:"+medicinemno);
	String medicinename = medicine.getMname();
	String mmode = medicine.getMmode();
	String mefficacy = medicine.getMefficacy();
%>
<body>
	<form id="medicineForm" name="client" method="post"
		action="./MedicineServlet?method=add">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input name="medicinemno" type="text" id="txtNum"
					value="<%=medicinemno%>" onBlur="return checkNum()"></td>
				<td><span id="tips_num">* 请输入药品编号</span>
				<td>
			</tr>
			
			<tr>
				<td>用 户 名</td>
				<td><input name="medicinename" type="text" id="txtMedicinename"
					value="<%=medicinename%>" onBlur="return Medicinename()"></td>
				<td><span id="tips_medicinename">* 请填写药品名称</span>
				<td>
			</tr>
			
			<tr>
				<td>服用方法</td>
				<td><input name="mmode" type="radio" value="内服"
					<%if (mmode.equals("内服"))
				out.print("checked='true'");%>
					onClick="return checkMode()" />内服 <input name="mmode" type="radio"
					value="外用"
					<%if (mmode.equals("外用"))
				out.print("checked='true'");%>
					onClick="return checkMode()" />外用</td>
				<td><span id="tips_mmode">* 请选择服用方法</span></td>
			</tr>
			
			<tr>
				<td>功效</td>
				<td><textarea name="mefficacy" cols="40" rows="5"
						id="txtMefficacy" onblur="return checkMefficacy()"><%=mefficacy%></textarea></td>
				<td><span id="tips_mefficacy">* 请填写药品功效</span></td>
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