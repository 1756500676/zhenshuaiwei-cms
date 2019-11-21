<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <!-- 引入CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/styles.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.2.1.js"></script>
    <title>学生管理系统 | 登录页面 </title>
</head>
<body>


<div class="wrapper">

	<div class="container">
		<h1>Welcome</h1>
		<form class="form" method="post">
			<input type="text" name="username" placeholder="用户名">
			<input type="password" name="password" placeholder="密码">
			<img alt="" src="/user/getCodeStr" id="codeImage" onclick="changeCode()">
			<input type="text" name="code" placeholder="验证码">
			<button type="button" id="login-button">登录</button>
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

<script type="text/javascript">
$('#login-button').click(function(event){
 	$.ajax({
		url:"/user/goLogin",
		type:"post",
		data:$("form").serialize(),
		dataType:"json",
		success:function(data){
			if (data.status == 100) {
				alert("登入成功");
				if (data.info.user_admin) {
					location = "/admin";
				}else{
					location = "/index";
				}
				
			}else{
				alert(data.info.error);
				location.reload(true);
			}			
		}
	});
});
function changeCode() {
	var src = $("#codeImage").attr("src");
	src = src + "?math="+Math.random();
	$("#codeImage").attr("src",src);
	
}
</script>

</body>

</html>