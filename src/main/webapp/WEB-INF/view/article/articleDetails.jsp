<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/jquery/icons.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
	
	
	
		<h2>${article.title }</h2>
		<div>
					频道:<a href="#">${article.channel.name }</a> 分类:<a href="#">${article.category.name}</a>
					<br> <a href="#">${article.user.username }</a>发布于
					<fmt:formatDate value="${article.created }" pattern="YYYY年MM月dd日" />
					${article.content }
		</div>
		
		
		
			<div>
				<nav aria-label="...">
					<ul class="pager">
						<li><a href="/article/getArticleById?id=${article.id }&protal=${protal}&page=pre">上一篇</a></li>
						<li><a href="/article/getArticleById?id=${article.id }&protal=${protal}&page=next">下一篇</a></li>
					</ul>
				</nav>
			</div>
		<div>
			<!-- 	显示文章的评论 -->
		</div>
	</div>
</body>
</html>