<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
<base href="${pageContext.request.contextPath }/">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="/navigation.jsp"%>
	<hr>
	<div class="container" style="width: 500px; margin-left: auto;">
		<form action="task/add" method="post" role="form">
			<input type="hidden" name="u_id" value="${u_id}">
			<div class="form-group">
				<label class="col-sm-2 control-label">日期</label>
				<div class="col-sm-10">
					<input type="date" class="form-control"
						style="font-family: '微软雅黑';" name="date">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label">消息</label>
				<div class="col-sm-10">
					<textarea rows="10" cols="30" name="information"
						class="form-control" class="form-control"> </textarea>
					<br>
				</div>
			</div>
			<br>
			<div align="center">
				<input type="submit" id="btn" value="提交" class="btn btn-success">
				<input type="reset" class="btn btn-danger">
			</div>
		</form>
	</div>
	<hr>
</body>
</html>