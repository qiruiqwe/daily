<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${not pagination.first }">
				<li><a href="${pagination.uri }?number=1&size=${pagination.size }">首页</a></li>
				<li><a href="${pagination.uri }?number=${pagination.number }&size=${pagination.size }">上一页</a></li>
			</c:if>
			<c:forEach begin="1" end="${pagination.totalPages }" varStatus="s">
				<li ${pagination.number+1 == s.index ? 'class="active"' : '' }>
					<a href="${pagination.uri }?number=${s.index }&size=${pagination.size }">第${s.index }页</a>
				</li>
			</c:forEach>
			<c:if test="${not pagination.last }">
				<li><a href="${pagination.uri }?number=${pagination.number + 2 }&size=${pagination.size }">下一页</a></li>
				<li><a href="${pagination.uri }?number=${pagination.totalPages }&size=${pagination.size }">尾页</a></li>
			</c:if>
		</ul>
	</div>
