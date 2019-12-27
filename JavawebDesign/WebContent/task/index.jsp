<%@page import="entity.Task"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>时光沙漏</title>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/about.css">
</head>

<body>
	<%@include file="/navigation.jsp"%>
	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoftYaHei';">
		<div class="page">
			<div class="box">
				<ul class="event_year">
					<c:forEach items="${years}" var="year" varStatus="status">
						<c:if test="${status.index == 0}">
							<li class="current"><label for="${year}">${year}</label></li>
						</c:if>
						<c:if test="${status.index != 0}">
							<li ><label for="${year}">${year}</label></li>
						</c:if>
					</c:forEach>
				</ul>
				<ul class="event_list">
					<c:forEach items="${years}" var="year">
						<div>
							<h3 id="${year}">${year}</h3>
							<c:forEach items="${tasks}" var="task">
								<c:if test="${task.year==year}">
									<li><span>${task.month}月${task.day}日</span>
										<p>
											<span>${task.information}</span>
										</p></li>
								</c:if>
							</c:forEach>
						</div>
					</c:forEach>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<script src="js/jquery.min_v1.0.js" type="text/javascript"></script>
		<script>
			$(function() {
				$('label').click(
						function() {
							$('.event_year>li').removeClass('current');
							$(this).parent('li').addClass('current');
							var year = $(this).attr('for');
							$('#' + year).parent().prevAll('div').slideUp(800);
							$('#' + year).parent().slideDown(800)
									.nextAll('div').slideDown(800);
						});
			});
		</script>
	</div>
</body>

</html>