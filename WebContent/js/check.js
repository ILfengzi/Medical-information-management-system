/*检查编号（通用）*/
function checkNum() {
	//判断其长度是否合法
	if (document.getElementById("txtNum").value.length < 1
			|| document.getElementById("txtNum").value.length > 12) {
		// 设置id为tips_num的<span>的HTML，显示错误信息
		document.getElementById("tips_num").innerHTML = "<em style='color:red'>编号由1-12个字符组成</em>";
		document.getElementById("txtNum").focus();
		// return false;
	} else {
		document.getElementById("tips_num").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查顾客编号*/
function checkCno() {
	//判断其长度是否合法
	if (document.getElementById("txtCno").value.length < 1
			|| document.getElementById("txtCno").value.length > 12) {
		// 设置id为tips_num的<span>的HTML，显示错误信息
		document.getElementById("tips_cno").innerHTML = "<em style='color:red'>编号由1-12个字符组成</em>";
		document.getElementById("txtCno").focus();
		// return false;
	} else {
		document.getElementById("tips_cno").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查经办人编号*/
function checkAno() {
	//判断其长度是否合法
	if (document.getElementById("txtAno").value.length < 1
			|| document.getElementById("txtAno").value.length > 12) {
		// 设置id为tips_num的<span>的HTML，显示错误信息
		document.getElementById("tips_ano").innerHTML = "<em style='color:red'>编号由1-12个字符组成</em>";
		document.getElementById("txtAno").focus();
		// return false;
	} else {
		document.getElementById("tips_ano").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查药品编号*/
function checkMno() {
	//判断其长度是否合法
	if (document.getElementById("txtMno").value.length < 1
			|| document.getElementById("txtMno").value.length > 12) {
		// 设置id为tips_num的<span>的HTML，显示错误信息
		document.getElementById("tips_mno").innerHTML = "<em style='color:red'>编号由1-12个字符组成</em>";
		document.getElementById("txtMno").focus();
		// return false;
	} else {
		document.getElementById("tips_mno").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查用户名*/
function checkName() {
	//判断其长度是否合法
	if (document.getElementById("txtName").value.length < 1
			|| document.getElementById("txtName").value.length > 8) {
		// 设置id为tips_name的<span>的HTML，显示错误信息
		document.getElementById("tips_name").innerHTML = "<em style='color:red'>用户名由1-8个字符组成</em>";
		document.getElementById("txtName").focus();
		// return false;
	} else {
		document.getElementById("tips_name").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查药品名称*/
function Medicinename() {
	if (document.getElementById("txtMedicinename").value.length < 1) {
		document.getElementById("tips_medicinename").innerHTML = "<em style='color:red'>请填写正确的药品名称</em>";
		document.getElementById("txtMedicinename").focus();
		// return false;
	} else {
		document.getElementById("tips_medicinename").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查密码 */
function checkPassword() {
	// 正则表达式，由字母、数字和下划线组成
	var reg = /[^A-Za-z0-9_]+/;
	var regs = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;

	// 判断密码长度，是否符合规则。
	if (document.getElementById("txtPwd").value.length < 6
			|| document.getElementById("txtPwd").value.length > 18
			|| regs.test(document.getElementById("txtPwd").value)) {
		document.getElementById("tips_password").innerHTML = "<em style='color:red'>密码由6-18个字符、数字和标点符号组成</em>";
		document.getElementById("txtPwd").focus();
		// return false;
	} else {
		document.getElementById("tips_password").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 确认密码 */
function checkPwdrepeat() {
	// 校验两次密码输入是否一致
	if (document.getElementById("txtRpt").value != document
			.getElementById("txtPwd").value) {
		document.getElementById("tips_pwdrepeat").innerHTML = "<em style='color:red'>两次输入的密码不一致</em>";
		document.getElementById("txtRpt").focus();
		// return false;
	} else {
		document.getElementById("tips_pwdrepeat").innerHTML = "<em style='color:green'>OK!</em>";
	}

}

/*检查手机号*/
function checkPhone() {
	//判断其长度是否合法
	if (document.getElementById("txtPhone").value.length != 11) {
		// 设置id为tips_phone的<span>的HTML，显示错误信息
		document.getElementById("tips_phone").innerHTML = "<em style='color:red'>请填写正确的11位手机号</em>";
		document.getElementById("txtPhone").focus();
		// return false;
	} else {
		document.getElementById("tips_phone").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查备注 */
function checkRemarks() {
	if (document.getElementById("txtRemarks").value.length > 100) {
		document.getElementById("tips_remarks").innerHTML = "<em style='color:red'>长度不能超过100个字符</em>";
		document.getElementById("txtRemarks").focus();
	} else {
		document.getElementById("tips_remarks").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查药品功效 */
function checkMefficacy() {
	if (document.getElementById("txtMefficacy").value.length < 1) {
		document.getElementById("tips_mefficacy").innerHTML = "<em style='color:red'>药品功效必须填写</em>";
		document.getElementById("txtMefficacy").focus();
	} else {
		document.getElementById("tips_mefficacy").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查服用方法 */
function checkMode() {
	// 获取所有的名称为mmode的input标签
	var genderNum = document.getElementsByName("mmode");
	var gender = "";
	// 遍历这些名称为gender的标签
	for (var i = 0; i < genderNum.length; ++i) {
		// 如果某个gender被选中，则记录
		if (genderNum[i].checked)
			gender = genderNum[i].value;
	}
	if (gender == "") {
		document.getElementById("tips_mmode").innerHTML = "<em style='color:red'>至少选择其中一项</em>";
		// return false;
	} else {
		document.getElementById("tips_mmode").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查性别 */
function checkGender() {
	// 获取所有的名称为gender的input标签
	var genderNum = document.getElementsByName("gender");
	var gender = "";
	// 遍历这些名称为gender的标签
	for (var i = 0; i < genderNum.length; ++i) {
		// 如果某个gender被选中，则记录
		if (genderNum[i].checked)
			gender = genderNum[i].value;
	}
	if (gender == "") {
		document.getElementById("tips_gender").innerHTML = "<em style='color:red'>至少选择其中一项</em>";
		// return false;
	} else {
		document.getElementById("tips_gender").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/*检查顾客年龄*/
function checkCage() {
	if (document.getElementById("txtCage").value.length < 1
			|| document.getElementById("txtCage").value.length > 4
			|| regs.test(document.getElementById("txtCage").value)) {
		document.getElementById("tips_cage").innerHTML = "<em style='color:red'>年龄由1-4个数字组成</em>";
		document.getElementById("txtCage").focus();
		// return false;
	} else {
		document.getElementById("tips_cage").innerHTML = "<em style='color:green'>OK!</em>";
	}
}

/* 检查顾客住址 */
function checkAddress() {
	if (document.getElementById("txtAddress").value.length > 100) {
		document.getElementById("tips_address").innerHTML = "<em style='color:red'>长度不能超过100个字符</em>";
		document.getElementById("txtAddress").focus();
	} else {
		document.getElementById("tips_address").innerHTML = "<em style='color:green'>OK!</em>";
	}
}