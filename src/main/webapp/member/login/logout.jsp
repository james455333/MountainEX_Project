<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
 
 <script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<meta charset="UTF-8">
<title>User Logout</title>
</head>
<body>


	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
						<!-- 	將使用者名稱取出 -->
				<c:set var="memberId" value="${LoginOK.memberId}" />
				
			<!-- 	移除放在session物件內的物件屬性 -->
				<c:remove var="LoginOK" scope="session" />
				
			<!-- 	session.removeAttribute("LoginOK") -->
				<c:remove var="ShoppingCart" scope="session" />
				
			<!-- 	下列敘述設定變數funcName的值為OUT，top.jsp會用到此變數 -->
				<c:set var="funcName" value="OUT" scope="session" />
		
				
			<!-- 下列六行敘述設定登出後要顯示登出後訊息 -->
				<c:set var="logoutMessage" scope="request" />
				<h2>
				<font color="blue">
					${MemberBean.name}，您已登出，感謝您的使用。<br/>
				</font>
				</h2>
			
				<jsp:useBean id="logoutBean" class="member.login.model.LogoutBean" scope="page" />
				<c:set target="${logoutBean}" property="session" value="${pageContext.session}" />
			
			<!-- ${logoutBean.logout} -->	
			
			

		</div>

		<footer> 
		
		</footer>

	</div>

	
	
	<script src="../../pan/jsFolder/index.js"></script> 
	<script>
	$("#content").append("<h3>登出成功</h3>");
	$("#content").append("<h4></h4>");
	
	for(let i = 2 ;  i >=0 ; i--){
		window.setTimeout(function(){
			$("#content").find("h4").text("將在"+i+"秒後跳轉至會員登入頁")
		},1000*(((-i)+2)))
	}
	window.setTimeout(function(){
		document.location.href="login.jsp";
	},3000) 
	</script>
</body>
</html>