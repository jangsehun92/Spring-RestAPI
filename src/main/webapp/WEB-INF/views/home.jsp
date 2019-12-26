<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
window.onload = function() {
	pagination(1);
};

function pagination(page){
	$("#boardBody").empty();
	$("#pagination").empty();
	$.ajax({
		url:"/articles?page="+page,
		type:"get",
		contentType : "application/json; charset=UTF-8",
		dataType : "json", 
		
		success:function(data){
			if(data.articleList[0] != null){
				for(var ele in data.articleList){
					$("#boardBody").append(
						"<tr>"+
							"<td>"+data.articleList[ele].id+"</td>"+
							"<td><a href='/article/"+data.articleList[ele].id+"'>"+data.articleList[ele].title+"</a></td>"+
							"<td align='right'>"+data.articleList[ele].writer+"</td>"+
							"<td align='right'>"+uxin_timestamp(data.articleList[ele].regDate)+"</td>"+
						"</tr>"
					);
				}
				
				console.log("pagination",data.pagination);
				
				if(data.pagination.startPage > 1){
					$("#pagination").append("<li class=''><a href='#' onclick='page(1)' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
				}else{
					$("#pagination").append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
				}
				
				if(data.pagination.page > 1){
					$("#pagination").append("<li class=''><a href='#' onclick='page("+(data.pagination.page-1)+")' aria-label='Previous'><span aria-hidden='true'>&lang;</span></a></li>");
				}else{
					$("#pagination").append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&lang;</span></a></li>");
				}
				
				for(var iCount = data.pagination.startPage; iCount <= data.pagination.endPage; iCount++) {
					if (iCount == data.pagination.page) {
				       $("#pagination").append("<li class='active'><a href='#'>"+iCount+"<span class='sr-only'></span></a></li>");
				    } else {
				    	$("#pagination").append("<li class=''><a a href='#' onclick='page("+iCount+")'>" + iCount + "<span class='sr-only'></span></a></li>");
				    }
				}
				
				if(data.pagination.page < data.pagination.totalPage){
					$("#pagination").append("<li class=''><a a href='#' onclick='page("+(data.pagination.page+1)+")' aria-label='Next'><span aria-hidden='true'>&rang;</span></a></li>");
				}else{
					$("#pagination").append("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&rang;</span></a></li>");
				}
				
				if(data.pagination.endPage < data.pagination.totalPage){
					$("#pagination").append("<li class=''><a href='#' onclick='page("+data.pagination.totalPage+")' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
				}else{
					$("#pagination").append("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
				}

			}else{
				$("#boardTable").append(
					"<tr>"+
						"<td colspan='4' align='center'>등록된 게시글이 없습니다.</td>"+
					"</tr>"
				);
			}
		},
		error:function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

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
</script>
<body>
<div style="text-align: center">
	<h1>
		게시판
	</h1>
</div>
<div class = "container">
	<div class="main">
		<div id="board">
			<table class="table table-hover" id="boardTable">
			<thead>
				<tr>
					<td class="col-md-1"><b>번호</b></td>
					<td class="col-md-6"><b>제목</b></td>
					<td class="col-md-1" align="right"><b>작성자</b></td>
					<td class="col-md-2" align="right"><b>작성 날짜</b></td>
				</tr>
			</thead>
			<tbody id="boardBody">
			
			</tbody>
		</table>
		
		<div style="float: right">
				<a href="/article/create" class="btn btn-primary">글쓰기</a>
		</div>
		
		<div>
			<!-- 페이지네이션 위치 -->
			<nav aria-label="..." style="text-align: center;">
				<ul class="pagination" id="pagination">
				</ul>
			</nav>
		</div>
		
		</div>
	</div>
</div>
</body>
</html>
