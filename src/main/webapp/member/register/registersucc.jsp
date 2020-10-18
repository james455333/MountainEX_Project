<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- functionCheck 的 value對應值 -->
<!-- 會員登入 = logging -->
<!-- 會員資料 = memberInfo -->
<!-- 資料維護 = maintainInfo -->
<!-- 百戰百岳 = mountain -->
<!-- 露營地/山中小屋 = house -->
<!-- 購物商城 = shopping -->
<!-- 討論區 = platform -->

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>岳進者</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
 
 <script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>
</style>
</head>

<body>

<!-- <c:set var='functionCheck'  value="none" scope="session"/> -->

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
			

		</div>

		<footer> 
		
		</footer>

	</div>

	
	 <script src="../../pan/jsFolder/index.js"></script> 
	<script id="contentCov"></script>

	<script type="text/javascript">
		
		$("#content").append("<h2>註冊成功</h2>");
		$("#content").append("<h4></h4>");
		
		for(let i = 2 ;  i >=0 ; i--){
			window.setTimeout(function(){
				$("#content").find("h4").text("將在"+i+"秒後跳轉至登入頁")
			},1000*(((-i)+2)))
		}
		window.setTimeout(function(){
			document.location.href="../login/login.jsp";
		},3000) 
		
	</script>

		
		
</body>

</html>