<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<link href="css/Back_Loading.css" rel="stylesheet" type="text/css" />
	</head>
	<body >
		<div class="login_top">
			<img src="img/log_top.png">
		</div>
		<div class="login_box">
			<div class="login_l_img">
				<img src="img/login-img.png" />
			</div>
			<div class="login">
				<div class="login_logo">
					<a href="#"><img src="img/login_logo.png" /></a>
				</div>
				<div class="login_name">
					<p>天上人间会所</p>
				</div>
				<p style="color: red" align="center">${msg }</p>
				<form method="post" action="login">
					<input name="username" type="text" value="用户名" onfocus="this.value=''">
					<span id="password_text" 
					onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus();" 
					onblur="document.getElementById('password').style.display='none' "
					>密码</span>
					<input id="password" name="password" type="password" style="display: none;" />
					
					<input type="text" name="checkCode" placeholder="请输入验证码，点击更新">
					<img alt="" src="check-code" title="看不清，换一张" 
					onclick="this.src='check-code?' + Math.random()">   <br>
					<input value="登录" style="width:100%;" type="submit">
				</form>
			</div>
			<div class="copyright">聊城大学    天上人间会所 </div>
		</div>
	</body>
</html>