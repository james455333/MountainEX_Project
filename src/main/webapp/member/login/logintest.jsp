<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>會員登入</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
 <link rel="stylesheet" href="cssfolder/login.css">
<style>
</style>
</head>


<body>
<c:if test="${ !empty LoginOK }">
		<script>
			alert("已完成登入，關閉本視窗將導向會員資訊頁")
			document.location.href="../info/memberInfo.jsp";
		</script>
	</c:if>

<c:set var='functionCheck' value='logging' scope='session'/>

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
			<div id="barNav"></div>
			<form id="loginFrameTest2" action='<c:url value="LoginServletTest" />' method='post'>
				<h1 class="h3 mb-3 font-weight-normal">會員登入</h1>
				<label for="inputEmail" class="sr-only">帳號：</label>
					<input type="text" id="userId" name="userId" class="form-control" placeholder="請輸入會員帳號" required="" autofocus="">
					<span><Font color="red" size="-3">${ErrorMsgKey.LoginError}</Font></span>

				<label for="inputPassword" class="sr-only">密碼：</label>
					<input type="password" id="password" name="password" class="form-control" placeholder="請輸入密碼" required="">
					<span><Font color="red" size="-3">${ErrorMsgKey.LoginError}</Font></span>

				<div class="checkbox mb-3">
				    <label>
				    	<input type="checkbox" value="remember-me"> Remember me
				    </label>
			  	</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			
			</form>
			

		</div>
		
		
		
		<footer> 
		
		</footer>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	 <script src="../../pan/jsFolder/index.js"></script> 
	<script id="contentCov"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
		
</body>

</html>