<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>时光沙漏</title>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<%@include file="/navigation.jsp"%>
	<hr>
	<div class="container">

		<table class="table table-striped">
			<tr>
				<th>标号</th>
				<th>年</th>
				<th>月</th>
				<th>日</th>
				<th>信息</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pagination.list}" var="task">
				<tr>
					<td>${task.id }</td>
					<td>${task.year }</td>
					<td>${task.month }</td>
					<td>${task.day}</td>
					<td>${task.information}</td>
					<td><a href="task/delete?id=${task.id}"
						class="btn btn-danger">删除</a>
					<a href="task/edit?id=${task.id}"
						class="btn btn-danger">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/pagination.jsp"%>
	</div>
	<hr>
	<br>
</body>

</html>