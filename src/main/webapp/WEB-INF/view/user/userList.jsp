<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>用户管理</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">输入姓名</a>
			</div>
			<div>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" name="searchName" value="${name }"  placeholder="Search">
					</div>
					<input type="button" class="btn btn-default" onclick="search()" value="查询" />
				</form>
			</div>
		</div>
	</nav>

<div class="table-responsive">
	<div style="height: 330px">
	  <table class="table" >
	    <caption>用户列表</caption>
	    <thead>
	      <tr >
	        <th>用户id</th>
	        <th>用户名称</th>
	        <th>注册日期</th>
	        <th>修改日期</th>
	        <th>角色</th>
	        <th>状态</th>
	        <th>操作</th>
	       </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${info.list}" var="user">
		      <tr >
		        <td>${user.id }</td>
		        <td>${user.username }</td>
		        <td><fmt:formatDate value="${user.createTime }" pattern="YYYY年MM月dd日"/></td>
		        <td><fmt:formatDate value="${user.updateTime }" pattern="YYYY年MM月dd日"/></td>
		        <td>
		        	<c:choose>
		        		<c:when test="${user.role == 0 }">普通用户</c:when>
		        		<c:when test="${user.role == 1 }">管理员</c:when>
			        	<c:otherwise>未知</c:otherwise>
		        	</c:choose>
		        </td>
		        <td>${user.locked == 0 ? '正常': '禁用' }</td>
		        <td>
		        		<button type="button" class="btn btn-danger" onclick="updateUserLocked(${user.id },1)">禁用</button>
		        		<button type="button" class="btn btn-info" onclick="updateUserLocked(${user.id },0)">解禁</button>
		        </td>
		       </tr>
	    	</c:forEach>
	    </tbody>
	  </table>
	 </div>
  <div class="row">
  	<div class="col-md-5">
  		<div class="dataTables_info" id="datatable_info" role="status" aria-live="polite">
  			Showing ${info.startRow } to ${info.endRow } of ${info.total } entries  
  		</div>
  	</div>
  	<div class=" col-md-5">
		 <div class="" id="" style="float: right">
			 <ul class="pagination">
			 	
			    <li class=""><a href="javascript:goPage(${info.pageNum == 1 ? 1 : info.pageNum - 1 })" >&laquo;</a></li>
			    
			    <c:if test="${info.pages == 5 }">
					<c:forEach var="count" varStatus="index" begin="1" end="5">
					    <li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
					 </c:forEach>
			    </c:if>
			    
			    <c:if test="${info.pages != 5 }">
				 	<c:choose>
				 		<c:when test="${info.pageNum > 2 && info.pageNum < (info.pages -1) }">
						    <c:forEach var="count" varStatus="index" begin="${info.pageNum -2}" end="${info.pageNum + 2}">
						    	<li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
						    </c:forEach>
				 		</c:when>
				 		<c:when test="${info.pageNum == 2 }">
						    <c:forEach var="count" varStatus="index" begin="${info.pageNum - 1}" end="${info.pageNum + 3}">
						    	<li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
						    </c:forEach>
				 		</c:when>
				 		<c:when test="${info.pageNum == 1 }">
						    <c:forEach var="count" varStatus="index" begin="${info.pageNum}" end="${info.pageNum + 4}">
						    	<li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
						    </c:forEach>
				 		</c:when>
				 		<c:when test="${info.pageNum == info.pages }">
						    <c:forEach var="count" varStatus="index" begin="${info.pageNum - 4}" end="${info.pages}">
						    	<li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
						    </c:forEach>
				 		</c:when>
				 		<c:when test="${info.pageNum == (info.pages - 1)}">
						    <c:forEach var="count" varStatus="index" begin="${info.pageNum - 3}" end="${info.pageNum +1 }">
						    	<li class="${count == info.pageNum ?  'active' : '' }"><a href="javascript:goPage(${count })" class="">${count }</a></li>
						    </c:forEach>
				 		</c:when>
				 	</c:choose>
				 </c:if>
			    
			    <%-- <c:forEach var="count" varStatus="index" begin="${info.pageNum > 2 ? info.pageNum -2 : 1}" end="${info.pageNum + 2 > info.pages ? info.pages : info.pageNum+2}">
			    	<li><a href="javascript:goPage(${count })" class="">${count }</a></li>
			    </c:forEach> --%>
			    
			    <li><a href="javascript:goPage(${info.pageNum == info.pages ? info.pageNum : info.pageNum + 1 })">&raquo;</a></li>
			</ul>
		</div>
  	</div>
  	<div class="col-md-1"></div>
 </div>
    
</div>
	<script type="text/javascript">
		function updateUserLocked(id,locked) {
			$.ajax({
				url:"/user/updateUserLocked",
				type:"post",
				data:{id:id,locked:locked},
				dataType:"json",
				success:function(data){
					if (data.status == 100) {
						alert("修改成功");
						$("#context").load("/user/users");
					}else{
						alert(data.info.update_status_error);					
						$("#context").load("/user/users");
					}
				}
			});
		}
		function goPage(page) {
			var name = $("[name='searchName']").val();
			var url = "/user/users?page="+page+"&name="+name;
			$("#context").load(url);
		}
		function search() {
			var name = $("[name='searchName']").val();
			var url = "/user/users?name="+name;
			$("#context").load(url);
		}
		
		
	</script>
</body>
</html>