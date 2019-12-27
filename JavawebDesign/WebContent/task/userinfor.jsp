<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改</title>
<base href="${pageContext.request.contextPath }/">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<script language="JavaScript">
	function check() {
		var username = document.form1.username.value;
		var newpassword1 = document.form1.newpassword1.value;
		var newpassword2 = document.form1.newpassword2.value;
		if (username == "" || newpassword1 == "" || newpassword2 == "") {
			alert("任意信息不能为空，请重新填写！");
			return false;
		}
		if (newpassword1 == newpassword2)
			return true;
		else {
			alert("两次输入的密码不一致！！");
			return false;
		}
	}
</script>
<body>
	<%@include file="/navigation.jsp"%>
	<hr>
	<div class="container" style="width: 500px; margin-left: auto;">
		<form action="task/userpass" name="form1" method="post" role="form"
			onsubmit="return check()" class="form-horizontal">
			<input type="hidden" name="id" value="${u_id}">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"
						style="font-family: '微软雅黑';" name="username"
						value="${username}">
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label">新密码</label>
				<div class="col-sm-10">
					<input type="password" name="newpassword1" class="form-control"
						value="${password}">
				</div>
			</div>
			<br>
			<div class=" form-group">
				<label class="col-sm-2 control-label ">重复输入密码</label>
				<div class="col-sm-10 ">
					<input type="password" name="newpassword2" class="form-control ">
				</div>
			</div>
			<br /> <br />
			<div align="center">
				<input type="submit" value="提交 " class="btn btn-success "> <input
					type="reset" value="重置" class="btn btn-default ">
			</div>
		</form>
	</div>

</body>

</html>