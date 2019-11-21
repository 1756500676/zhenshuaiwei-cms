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
					还能输入<span id="contentNum">250</span>&nbsp;&nbsp;
					<button type="button" onclick="pushComment()" class="btn btn-danger">发表评论</button>
				</div>
			</form>
		</div>
		<hr>
		<!-- 文章评论 -->
		<span class="pull-right">${article.hits }次阅读&nbsp;&nbsp;评论数量:${article.commentCnt }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br><br>
		<div>
			<!-- 	显示文章的评论 -->
			<c:forEach items="${commentList }" var="comment">
				<!-- 文章的评论 -->
				<div>
					<!-- 发表文章的用户 -->
					<div>
						<img alt="" height="30px" width="30px" class="img-circle" src="/pic/${comment.user.url }" onerror="this.src='/static/images/default_user_url.png'">
						<b>${comment.user.username }</b>
							&nbsp;&nbsp;
							<fmt:formatDate value="${comment.created }" pattern="YYYY年MM月dd日 hh:MM:ss" />
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
				</div>
				<hr>
			</c:forEach>
		</div>
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

	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog"  >
                <div class="modal-content">
                        <div class="modal-body" style="height:600px;overflow-x:scroll;overflow-y:scroll">
                        
                        </div>
                </div><!-- /.modal-content -->
        </div><!-- /.modal -->
</div>	

	
	<script type="text/javascript">
		$(function() {
			$("#content").keyup(function () {
				var content = $("#content").val();	
				if (content.length >= 250) {
					$("#content").val(content.substring(0,250));
				}
				content = $("#content").val();	
				$("#contentNum").text(250 - content.length);
			});
		})
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
		               // window.location.href=XMLHttpRequest.getResponseHeader("CONTEXTPATH");
		                $('#myModal').modal('show')
		            }
				}
			});
		}
		
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
				},error:function(XMLHttpRequest, textStatus){
					var redirect=XMLHttpRequest.getResponseHeader("REDIRECT");
		            if(redirect=="REDIRECT"){
		                alert("请先登录！");
		                window.location.href=XMLHttpRequest.getResponseHeader("CONTEXTPATH");
		            }
				}
			});
		}
	</script>
	
	
</body>
</html>