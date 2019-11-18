<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- 导航条 -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
  	
  	<!-- logo -->
  	<div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/resource/images/logo.png">
      </a>
    </div>
    
    <!-- 搜索框和右侧登录信息 -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
      </ul>
      
      <form class="navbar-form navbar-left" >
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <!-- 个人头像信息 -->
      <c:if test="${sessionScope.user == null}">
      	<div class="pull-right">
	      	<a href="/user/login">登入</a>
	      	<a href="/user/toRegister">注册</a>
      	</div>
      </c:if>
      <c:if test="${sessionScope.user != null}">
	      <ul class="nav navbar-nav navbar-right">
	      	<li class="list-inline float-right mb-0">
	          	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">
	              <img src="<%=request.getContextPath() %>/static/images/IMG_0832.JPG" alt="user" width="40px" height="40px" class="img-circle">
	           </a>
				<ul class="dropdown-menu" >
				    <li><a href="/user/myCenter">个人中心</a></li>
		            <li><a href="#">个人设置</a></li>
		            <li><a href="#">修改头像</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="/user/outLogin">退出登录</a></li>
				</ul>
	        </li>   						
	      </ul>
      </c:if>
    </div><!-- /.navbar-collapse -->
    
  </div>
</nav>
    
