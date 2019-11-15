<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <!-- 引入CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css">
    <title>学生管理系统 | 登录页面 </title>
</head>
<body>


<div class="wrapper">

	<div class="container">
		<h1>Welcome</h1>
		<form class="form">
			<input type="text" placeholder="用户名">
			<input type="password" placeholder="密码">
			<button type="submit" id="login-button">登录</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

	<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$('#login-button').click(function(event){
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>

</body>

</html>