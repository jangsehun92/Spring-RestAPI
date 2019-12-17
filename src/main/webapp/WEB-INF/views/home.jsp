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
	
	$.ajax({
		url:"/articles",
		type:"get",
		contentType : "application/json; charset=UTF-8",
		dataType : "json", 
		
		success:function(data){
			//alert(data.articleList[0]);
			
			if(data.articleList != null){
				for(var ele in data.articleList){
					$("#boardTable").append(
						"<tr>"+
							"<td>"+data.articleList[ele].id+"</td>"+
							"<td>"+data.articleList[ele].title+"</td>"+
							"<td align='right'>"+data.articleList[ele].writer+"</td>"+
							"<td align='right'>"+uxin_timestamp(data.articleList[ele].regDate)+"</td>"+
						"</tr>"
					);
				}

				//alert(data.articleList[0].id);
				/*
				$("#boardTable").append(
					"<tr>"+
						"<td>"+data.articleList[0].id+"</td>"+
						"<td>"+data.articleList[0].title+"</td>"+
						"<td align='right'>"+data.articleList[0].writer+"</td>"+
						"<td align='right'>"+uxin_timestamp(data.articleList[0].regDate)+"</td>"+
					"</tr>"
				);
				*/
			}
			//alert(data.pagination.totalCount);
		},
		error:function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	return false;

};

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
<h1>
	게시판  
</h1>
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
				<tr id="articleList">
					
				</tr>
		</table>
		
		<div>
			<!-- 페이지네이션 위치 -->
		</div>
		
		</div>
	</div>
</div>
</body>
</html>
