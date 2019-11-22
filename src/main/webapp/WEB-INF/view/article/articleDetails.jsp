<%@page import="java.util.Date"%>
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
					<button class="fa fa-star-o btn" onclick="favoriteArticle(${article.id})">收藏</button>
					<hr>
					${article.content }
		</div>
		<hr>
		
		<!-- 写评论 -->
		<div>
			<form action="">
				<input type="hidden" name="articleId" value="${article.id }">
				<div>
					<img alt="" class="pull-left" height="30px" width="30px" class="img-circle" src="/pic/${comment.user.url }" onerror="this.src='/static/images/default_user_url.png'">
					<textarea rows="5"  cols="155" id="content" name="content" placeholder="相对作者说点什么"></textarea>
				</div>
				<div class="pull-right">
					还能输入<span id="contentNum" class="text-danger">250</span>&nbsp;&nbsp;
					<button type="button" onclick="pushComment()" class="btn btn-danger">发表评论</button>
				</div>
			</form>
		</div>
		<hr>
		<!-- 文章评论 -->
		<span class="pull-right">${article.hits }次阅读&nbsp;&nbsp;评论数量:${article.commentCnt }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br><br>
		<div>
			<!-- 	显示文章的评论 -->
			<c:forEach items="${info.list }" var="comment" varStatus="index">
				<!-- 文章的评论 -->
				<div>
					<c:if test="${index.count <= 3 || sessionScope.user != null }">
						<!-- 发表文章的用户 -->
						<div>
							<img alt="" height="30px" width="30px" class="img-circle" src="/pic/${comment.user.url }" onerror="this.src='/static/images/default_user_url.png'">
							<b>${comment.user.username }</b>
								&nbsp;&nbsp;
								${comment.dateDesc }
								<%-- <fmt:formatDate value="${comment.created }" pattern="YYYY年MM月dd日 HH:mm:ss" /> --%>
								<span class=" pull-right">
									<i class="fa fa-thumbs-o-up" onclick="likeComment(${comment.id})"></i>&nbsp;
									${comment.likeNum == 0 ? '' : comment.likeNum }	
								</span>
						</div>
						<!-- 发表的内容 -->
						<div>
							<br>
							${comment.content }
						</div>
						<hr>
					</c:if>
					<c:if test="${index.count == 3 && sessionScope.user == null }">
						<div class="text-center">
							<a  onclick="location ='/login?scrollTo=true&gotoArticle=${article.id}'" >登入查看${info.total }条热评</a>
						</div>
					</c:if> 
				</div>
			</c:forEach>
		</div>
		<!-- 评论分页 -->
		<c:if test="${sessionScope.user != null }">
			<div>
				  <%@include file="../common/page.jsp" %>
			</div>
		</c:if>
		<!-- 文章的上一篇下一篇 -->	
		<div>
			<nav aria-label="...">
				<ul class="pager">
					<li><a href="/article/getArticleById?id=${article.id }&protal=${protal}&page=pre">上一篇</a></li>
					<li><a href="/article/getArticleById?id=${article.id }&protal=${protal}&page=next">下一篇</a></li>
				</ul>
			</nav>
		</div>
	</div>


	
	<script type="text/javascript">
		$(function() {
			//判断还可以输入多少字
			$("#content").keyup(function () {
				var content = $("#content").val();	
				if (content.length >= 250) {
					$("#content").val(content.substring(0,250));
				}
				content = $("#content").val();	
				$("#contentNum").text(250 - content.length);
			});
			 
		})
		//发布评论
		function pushComment() {
			$.ajax({
				url:"/comment/pushComment",
				type:"post",
				data:$("form").serialize(),
				dataType:"json",
				success:function(data){
					if (data.status == 100) {
						alert("发布成功");
						location.reload(true);
					}else{
						alert(data.info.error);
					}			
				},error:function(XMLHttpRequest, textStatus){
					var redirect=XMLHttpRequest.getResponseHeader("REDIRECT");
		            if(redirect=="REDIRECT"){
		                alert("请先登录！");
		               window.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"));
		            }
				}
			});
		}
		//点赞评论
		function likeComment(id) {
			$.ajax({
				url:"/comment/likeComment",
				type:"post",
				data:{id:id},
				dataType:"json",
				success:function(data){
					if (data.status == 100) {
						location.reload(true);
					}else{
						alert(data.info.error);
					}			
					//处理ajax内部重定向
				},error:function(XMLHttpRequest, textStatus){
					var redirect=XMLHttpRequest.getResponseHeader("REDIRECT");
		            if(redirect=="REDIRECT"){
		                alert("请先登录！");
		               window.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"));
		            }
				}
			});
		}
		//收藏文章
		function favoriteArticle(id) {
			$.ajax({
				url:"/article/favoriteArticle",
				type:"post",
				data:{id:id},
				dataType:"json",
				success:function(data){
					if (data.status == 100) {
						alert("收藏成功");
						location.reload(true);
					}else{
						alert(data.info.error);
					}			
				},error:function(XMLHttpRequest, textStatus){
					var redirect=XMLHttpRequest.getResponseHeader("REDIRECT");
		            if(redirect=="REDIRECT"){
		                alert("请先登录！");
		               window.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"));
		            }
				}
			});
		}
		//分页
		function goPage(page) {
			var url = "/article/getArticleById?id=${article.id}&scrollTo=true&pageNum="+page;
			location = url;
		}
		//分分页之后到底部
		if ("${scrollTo}" == "true") {
			 window.scrollTo(0, document.body.scrollHeight)
		}
	</script>
	
	
</body>
</html>