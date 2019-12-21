<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_insert</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
textarea {min-height: 50px;}
</style>
<script type="text/javascript">
//textarea 입력값에 따라 height 조절
function resize(obj){
	obj.style.height = "1px";
	obj.style.height = (12+obj.scrollHeight)+"px";
}

//유효성 검사
function check_form(){
	//replace 로 공백 제거
	var inputForm_title = $("#title").val().replace(/\s|/gi,'');
	var inputForm_writer = $("#writer").val().replace(/\s|/gi,'');
	var inputForm_password = $("#password").val().replace(/\s|/gi,'');
	var inputForm_content = $("#content").val().replace(/\s|/gi,'');
	
	if(inputForm_title==""){
		alert("제목을 입력해주세요.");
		$("#title").val("");
		$("#title").focus();
		return false;
	}
	
	if(inputForm_password==""){
		alert("비밀번호를 입력해주세요.");
		$("#password").val("");
		$("#password").focus();
		return false;
	}
	
	if(inputForm_writer==""){
		alert("작성자를 입력해주세요.");
		$("#writer").val("");
		$("#writer").focus();
		return false;
	}
	
	if(inputForm_content==""){
		alert("내용을 입력해주세요.");
		$("#content").val("");
		$("#content").focus();
		return false;
	}
}
</script>

<body>
<div class="container" style="margin-top: 50px">
	<div class="form">
		<h2>글쓰기</h2>
		<form method="post" action="/article" onsubmit="return check_form();">
			<table class="table">
				<tr>
					<td><input id="writer" name="writer" type="text" class="form-control" placeholder="작성자" maxlength="12"></td>
				</tr>
				<tr>
					<td><input id="password" name="password" type="password" class="form-control" placeholder="비밀번호" maxlength="64"></td>
				</tr>
				<tr>
					<td><input id="title" name="title" type="text" class="form-control" placeholder="제목" maxlength="50"></td>
				</tr>
				<tr>
					<td><textarea id="content" name="content" class="form-control" placeholder="내용" onkeydown="resize(this)"></textarea>
				</tr>
			</table>
			<a href="/articles" class="btn btn-primary">목록</a>
			<input type="submit" class="btn btn-primary" value="완료">
		</form>
	</div>
</div>
</body>
</html>