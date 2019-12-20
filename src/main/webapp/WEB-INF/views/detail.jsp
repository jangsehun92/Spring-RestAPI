<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>board_detail</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
function uxin_timestamp(time){
	var date = new Date(time);
	var year = date.getFullYear();
	var month = "0" + (date.getMonth()+1);
	var day = "0" + date.getDate();
	var hour = "0" + date.getHours();
	var minute = "0" + date.getMinutes();
	//var second = "0" + date.getSeconds();
	return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2);
}

function deleteConfirm(id){
	if(confirm("삭제하시겠습니까?")){
		replyDelete(id);
	}else{
		return;
	}
}


</script>
<body>
<div class="container" style="margin-top: 50px">
	<div class="header">
		<h2>글보기</h2>
		<hr>
			<ul class="list-group">
				<li class="list-group-item">
					<div class="title">
						<h3>${article.title }</h3>
					</div>
					<div class="row" >
						<div class="col-md-4" style="float: left">
							<span>${article.writer } |</span> <span><small><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${article.regDate }"/></small></span>
						</div>
					</div>
				</li>
				<li class="list-group-item">
					<div>
						<div id="board_content" style="white-space : pre-wrap;height: 100%">${article.content }</div>
					</div>
				</li>
			</ul>
				<div class="row" style="margin-left: 0px; margin-right: 0px">
					<div style="float: left">
						<a href="/articles" class="btn btn-primary">목록</a>
					</div>
						<div style="float: left">
						<!--  <input type="button" class="btn btn-primary" value="수정" onclick="location.href='/article/${article.id}'"> -->
						<form method="post" action="/article/${article.id }">
							<input type="hidden" name="_method" value="put"/>
							<input type="submit" class="btn btn-primary" value="수정">
						</form>
						
						<div style="float: left">
							<form method="post" action="/article/${article.id }">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" class="btn btn-primary" value="삭제">
							</form>
						</div>
				</div>
			</div>
			<hr>
				<input type="button" class="btn btn-primary" value="새로고침" onclick="listConfirm();">
	</div>
</div>
</body>
</html>
