<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>嘻嘻的小才@日记登录界面</title>
		<meta name="keywords" content="网站模板,手机网站模板,手机登录页面,登录页面HTML,免费网站模板下载" />
		<meta name="description" content="JS代码网提供高质量手机网站模板下载" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="webapp/assets/css/reset.css">
        <link rel="stylesheet" href="webapp/assets/css/supersized.css">
        <link rel="stylesheet" href="webapp/assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
        <form  method="post" action="${pageContext.request.contextPath }/login.action" onsubmit="return sendok();">
            <h1>账号登录</h1>
            <form action="" method="post">
                <input type="text" name="username" class="username" placeholder="用户名">
                <input type="password" name="password" class="password" placeholder="密码">
                <button type="submit">提交</button>
                <div class="error"><span>+</span></div>
            </form>
            </form>
            <div class="connect">
                <p>嘻嘻的小才</p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="webapp/assets/js/jquery-1.8.2.min.js"></script>
        <script src="webapp/assets/js/supersized.3.2.7.min.js"></script>
        <script src="webapp/assets/js/supersized-init.js"></script>
        <script src="webapp/assets/js/scripts.js"></script>

    </body>

</html>


