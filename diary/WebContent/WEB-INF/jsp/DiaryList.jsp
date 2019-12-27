 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
<link rel="stylesheet" href="webapp/css/reset.css">
<link rel="stylesheet" href="webapp/css/index.css">
</head>
<body>
    <header>
        <h1>嘻嘻的小才@日记</h1>
    <h4><script language="JavaScript">
    var isnMonth = new Array("1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月");
    var isnDay = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日");
    today = new Date () ;
    Year=today.getYear();
    Date=today.getDate();
    document.write("今天是: "+Year+"年"+isnMonth[today.getMonth()]+Date+"日"+isnDay[today.getDay()]);
    
	</script></h4>
    </header>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath }/diaryList.action">首页</a></li>
            <li><a href="${pageContext.request.contextPath }/diaryList2.action">日记列表</a></li>
            <li>
                <a href="${pageContext.request.contextPath }/showView.action">写日记</a></li>
            <li><a href="${pageContext.request.contextPath }/logout.action">退出</a></li>
        </ul>
    </nav>
    <div id="main">
        <div id="lside">
            <article>
            	<table width="100%" border=1>
<tr>
	<td>ID</td>
	<td>日记日期</td>
	<td>日记标题</td>
	<td>图片</td>
	<td>操作</td>
</tr>
<c:forEach items="${diaryList }" var="item">
<tr>
	<td>${item.id }</td>
	<td>${item.createtime }</td>
	<td>${item.title }</td>
	<td>${item.pic }</td>
	
	<td><a href="${pageContext.request.contextPath }/showDiary.action?id=${item.id}">修改|</a>
		<a href="${pageContext.request.contextPath }/deleteDiary.action?id=${item.id}">删除</a></td>

	</tr>
</c:forEach>

			</table>
            </article>
            <div id="pagebar">
                Pages:&nbsp;
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                4
                <a href="#">5</a>
                <a href="#">6</a>
            </div>
        </div>
        <div id="rside">
            <aside>
                <form action="${pageContext.request.contextPath }/searchDiary.action?search=search">
                    <input type="text" name="search" placeholder="Search...">
                </form>
            </aside>
            <aside>
                <h4>测试标题</h4>
                <ul>
                    <li><a href="">文章标题</a>&nbsp;(1)</li>
                    <li><a href="">文章标题</a>&nbsp;(3)</li>
                    <li><a href="">文章标题</a>&nbsp;(5)</li>
                    <li><a href="">文章标题</a>&nbsp;(3)</li>
                </ul>
            </aside>
            <aside>
                <h4>测试标题</h4>
                <ul>
                    <li><a href="">文章标题1</a></li>
                    <li><a href="">文章标题2</a></li>
                    <li><a href="">文章标题3</a></li>
                    <li><a href="">文章标题4</a></li>
                </ul>
            </aside>
            <aside>
                <h4>测试标题</h4>
                <ul>
                    <li><a href="">文章标题1</a></li>
                    <li><a href="">文章标题2</a></li>
                    <li><a href="">文章标题3</a></li>
                    <li><a href="">文章标题4</a></li>
                </ul>
            </aside>
            <aside>
                <h4>测试标题</h4>
                <ul>
                    <li><a href="">文章标题1</a></li>
                    <li><a href="">文章标题2</a></li>
                    <li><a href="">文章标题3</a></li>
                    <li><a href="">文章标题4</a></li>
                </ul>
            </aside>
        </div>
    </div>
    <footer>
       	 嘻嘻的小才@日记
    </footer>
</body>
</html>