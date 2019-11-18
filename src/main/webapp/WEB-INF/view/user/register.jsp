<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/jquery/icons.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<div class="container" style="background:url(/pic/timg.jpg)">
		<div   style="boder:solid; width:400px;height:400px;">
			
<form class="form-horizontal" id="regForm" role="form" >

	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="username" 
	      name="username" minlength="2" maxlength="8" 
	      remote="/user/checkname"
	      required="true"
	      placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="password2" name="password2" placeholder="请再次输入密码">
	    </div>
	  </div>
	
		
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="submit" class="btn btn-default" value="注册"  />
	    </div>
	  </div>
	</form>
	
		</div>
	</div>
	<script type="text/javascript">
		// regForm 需要校验  校验规则可以在这个函数内部 也可以直接写在 标签的属性上
		$("#regForm").validate({
			rules:{
				username:{
					minlength:6
				},password:{
					required:true,
				},password2:{
					required:true,
					minlength:6,
					equalTo:password
				}
			},messages:{
				username:{
					minlength:"用户名最少6位",
					maxlength:"用户名最多8位",
					remote:"该用户已存在"
				},password:{
					required:"密码不可为空",
					minlength:"密码最少6位"
				},password2:{
					required:"密码不可为空",
					minlength:"密码最少6位",
					equalTo:"两次输入不一致"
				}
			},submitHandler:function(){
				  	$.ajax({
					url:"/user/register",
					type:"post",
					data:$("form").serialize(),
					dataType:"json",
					success:function(data){
						if (data.status == 100) {
							alert("注册成功");
							location = "/user/login";
						}else{
							alert(data.info.register_error);
						}			
					}
				});
			}
		});
		
		function register() {
			$("#regForm").submit();	
		}
	</script>
</body>

</html>