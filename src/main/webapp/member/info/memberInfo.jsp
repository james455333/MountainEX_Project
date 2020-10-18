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
<title>User Info</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
<style>
	
</style>
</head>

<body>

<c:set var='functionCheck' value="memberInfo" scope="session"/>

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
			
			<form id="Info" action="<c:url value='/MemberInfoServlet' />" method="POST" >
			
				<fieldset>
					
					
						<h2>${MemberBean.name}的個人資料</h2>
					
						<label>帳號：</label>
						<span><c:out value="${MemberBean.memberId}" /></span>
						<br/>
		
						<label>姓名：</label>
						<span><c:out value="${MemberBean.name}" /></span>
						<br/>
		
						<label>地址：</label>
						<span><c:out value="${MemberBean.address}" /></span>
						<br/>
		
						<label>Email：</label>
						<span><c:out value="${MemberBean.email}" /></span>							
						<br>
		
						<label>電話：</label>
						<span><c:out value="${MemberBean.tel}" /></span>
						<br/>
		
						<label>登山經驗：</label>
						<span><c:out value="${MemberBean.exp}" /></span>
						<br/>
		
						<label>會員身分組：</label>
						<span>
							<c:if test="${MemberBean.groupId eq 100}">
								一般會員
							</c:if>
							<c:if test="${MemberBean.groupId eq 200}">
								登山嚮導
							</c:if>
						</span>
						<br/>
		
<!-- 						<label>購物車購買總額：</label> -->
<%-- 						<span><c:out value="${info.totalAmount}" /></span> --%>
<!-- 						<br/> -->
							
<!-- 						<label>未付款總額：</label> -->
<%-- 						<span><c:out value="${info.Unpaid_amount}" /></span> --%>
<!-- 						<br/> -->
					
				</fieldset>

			
				<input type="submit" id="update" name="update" value="修改資料">
				<input type="submit" id="logout" name="logout" value="會員登出">
			
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