<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath() %>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/jquery/icons.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap/js/bootstrap.js"></script>
<title>ZSW公司CMS管理平台</title>
</head>
<body>
	<div class="hrms_container">
		<!-- 导航条 -->
		<div class="hrms_brand_nav">
			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#hrms-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">CMS文章管理系统</a>
				</div>

				<div class="collapse navbar-collapse" id="hrms-navbar-collapse-1">
					  <ul class="nav navbar-nav">
                          <li class="active">
                            <a href="#">公司介绍 <span class="sr-only">(current)</span>  </a>
                          </li>
                          <li><a href="#">人力资源部</a></li>
                          <li><a href="#">请假申请</a></li>
                          <li><a href="#">报销申请</a></li>
                          <li><a href="#">出勤记录</a></li>
                        </ul>

					  <form class="navbar-form navbar-left">
                            <div class="form-group">
                              <input type="text" class="form-control" placeholder="站内搜索">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form> 

					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">账号管理 <span class="caret"></span></a>
							<ul class="dropdown-menu nav nav-pills nav-stacked">
								<li class="active"><a href="#"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										用户设置</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-user"
										aria-hidden="true"></span> 个人信息</a></li>
								<li class="hrms_logout"><a href="#"><span
										class="glyphicon glyphicon-off" aria-hidden="true"></span>
										账号退出</a></li>
							</ul></li>
					</ul>
					<!-- /.nav navbar-nav navbar-right -->
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid --> </nav>
		</div>
		<!-- /.hrms_brand_nav -->

		<!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
		<div class="hrms_body" style="position: relative; top: -15px;">

			<!-- 左侧栏 -->
			<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
				<ul class="nav nav-pills nav-stacked index_sidebar">
					<li role="presentation" class="active"><a href="#"> 
							<i class="ti-home" aria-hidden="true">首页</i>
					</a></li>
				</ul>
				<ul class="nav nav-pills nav-stacked article_sidebar">
					<li role="presentation" class="active">
						<a href="#" data-toggle="collapse" data-target="#collapse_article">
							 <span class="glyphicon glyphicon-user" aria-hidden="true">文章管理</span>
						</a>
						<ul class="nav nav-pills nav-stacked" id="collapse_article">
							<li role="presentation"><a href="#">员工信息</a></li>
							<li role="presentation"><a href="#">员工新增</a></li>
							<li role="presentation"><a href="#">员工清零</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav nav-pills nav-stacked vote_sidebar">
					<li role="presentation" class="active">
						<a href="#" data-toggle="collapse" data-target="#collapse_vote"> 
							<span class="glyphicon glyphicon-cloud" aria-hidden="true">投票管理</span>
						</a>
						<ul class="nav nav-pills nav-stacked" id="collapse_vote">
							<li role="presentation"><a href="#">投票列表</a></li>
							<li role="presentation"><a href="#">新建投票</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav nav-pills nav-stacked user_sidebar">
					<li role="presentation" class="active">
						<a href="#" data-toggle="collapse" data-target="#collapse_user"> 
							<span class="glyphicon glyphicon-user" aria-hidden="true">用户管理</span>
					</a>
						<ul class="nav nav-pills nav-stacked" id="collapse_user">
							<li role="presentation"><a href="javascript:shouContext('/user/users')">用户列表</a></li>
							<li role="presentation"><a href="#">新建投票</a></li>
						</ul></li>
				</ul>

			</div>
			<!-- /.panel-group，#hrms_sidebar_left -->

			<!-- 中间员工表格信息展示内容 -->
			<div class="col-sm-10 " id="context" >
			
			</div>
			<!-- /.hrms_body -->


			<nav class="navbar navbar-inverse navbar-fixed-bottom"
				role="navigation">
			<div align="center">
				<font color="blue" size="5"> ----八维大数据学院1707D--- </font>
			</div>
			</nav>

		</div>
	</div>
	<!-- js -->
	<script type="text/javascript">
		function shouContext(url) {
			$("#context").load(url);
		}
	</script>
</body>

</html>