<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath() %>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/jquery/icons.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap/js/bootstrap.js"></script>
 <title>头条首页</title>
</head>
<body>

<%@include file="common/top.jsp" %>

<div class="container-fluid" >
	<div class="container" style="minheight:200px" >
		<div class="row">
			<!-- 左侧菜单 -->
			<div class="col-md-2" style="minheight:200px;margin-top:20px" >
					<div class="list-group">
						 <a href="/index" class="list-group-item active">热门文章</a>
						<c:forEach items="${channelList }" var="channel">
							<a href="/article/getArticleByCG?chId=${channel.id }" class="list-group-item ${chId == channel.id ? 'active' : '' }">${channel.name }</a>
<%-- 						    <li class="list-group-item" data="article/getArticleByChannelId?channelId=${channel.id }"></li> --%>
						</c:forEach>
					</div>	
			</div>
			<!-- 中间的内容 -->
			<div class="col-md-8" style="background:white;minheight:200px" id="context" >
				<div>
						<hr>
						
				</div>
					<!-- 放搜索文章的列表 -->
					<div class="container" style="width: 780px" >
						<c:forEach items="${info.list }" var="hotArticle">
							<div class=row>
								 <hr>
								<div class="col-md-2">
									<img height="80px" width="80px" src="/pic/${hotArticle.picture}" onerror="this.src='/static/images/IMG_0832.JPG'" class="img-rounded">	
								</div>
								<div class="col-md-10 pull-left">
									<a href="javascript:showArticle('/article/getArticleById?id=${hotArticle.id }&protal=hot')">${hotArticle.title }</a>
									<br>
									频道:<a href="/article/getArticleByCG?chId=${hotArticle.channel.id }">${hotArticle.channel.name }</a>
									分类:<a href="/article/getArticleByCG?chId=${hotArticle.channel.id }&caId=${hotArticle.category.id }">${hotArticle.category.name}</a>
									<br>
								 	<a href="#">${hotArticle.user.username }</a> 发布于<fmt:formatDate value="${hotArticle.created }" pattern="YYYY年MM月dd日"/>
								 	<b class="pull-right">${hotArticle.hits }次阅读</b>
								</div>
							</div>
						</c:forEach>
						<%@include file="common/page.jsp" %>
					</div>
					 
			</div>
			<!-- 中间的内容结束 -->
			
			
			<div class="col-md-2" style="minheight:200px" >
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
					</div>
					<div class="panel-body">
						这是一个基本的面板
					</div>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">最新文章</h3>
					</div>
						<div class="panel-body">
							<ul class="pull-left">
								<c:forEach items="${newArticleList }" var="newArticle">
									<li><a href="javascript:showArticle('/article/getArticleById?id=${newArticle.id }&protal=new')">
										<c:if test="${newArticle.title.length() > 6 }">
											${newArticle.title.substring(0,5) }...
										</c:if>
										<c:if test="${newArticle.title.length() <= 6 }">
											${newArticle.title }
										</c:if>
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			
		</div>
		
	</div>
	<nav class="navbar navbar-fixed-bottom" role="navigation">
	
	<div class="container-fluid" style="text-align:center">
	 	<div class="row" style="margin-top:13px">
	 	    <div class="col-md-1"><a href="sohu.com" class="fl"></a></div>
	 			<%-- <c:forEach items="${links}" var ="link">
	 				<div class="col-md-1"><a href="${link.url}" class="fl"> ${link.name}</a></div>
	 			</c:forEach> --%>
	 		<div class="col-md-1"><a href="sohu.com" class="fl"></a></div>
	 	</div>
	 </div>
	
		<div align="center">
			  <footer class="footer">
	              © 2019 GigData - 1707D <i class="mdi mdi-heart text-danger"></i> ZSW.
	         		 </footer>
		</div>
	</nav>

</div>

<script type="text/javascript">
	function showChannel(url) {
		$("#context").load(url);
	}
	function showArticle(url) {
		window.open(url);
	}
	function goPage(page) {
		location = "/search?page="+page+"&searchV=${searchV}";
	}
</script>

<!-- 底部 -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
  </div>
</nav>

</body>
</html>