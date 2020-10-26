<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
<title>User InfoUpdate</title>
<style>
</style>
</head>
<body>

<c:set var='functionCheck' value='memberInfoUpdate' scope='session' />

	<div id="container">
	
<!-- 	共同頁首 -->
	<jsp:include page='/fragment/topbar.jsp' />
	
<!-- 	主要內容 -->
		<div id="content">
			<form id="InfoUpdate" action="<c:url value='/MemberInfoUpdateServlet' />" method="POST">
	
				<fieldset>

					<h2>${MemberBean.name}的個人資料</h2>
					
						<label>帳號：</label>
						<input type="text" id="userId" name="userId" readonly="readonly" value="${MemberBean.account}" />
						<br/>
						
						<label>密碼：</label>
						<input type="password" id="password" name="password" value="${MemberBean.password}" />
						<br/>
		
						<label>姓名：</label>
						<input type="text" id="name" name="name" value="${MemberBean.name}" />
						<br/>
		
						<label>地址：</label>
						<input type="text" id="address" name="address" value="${MemberBean.address}" />
						<br/>
		
						<label>Email：</label>
						<input type="email" id="email" name="email" value="${MemberBean.email}" />							
						<br>
		
						<label>電話：</label>
						<input type="text" id="tel" name="tel" value="${MemberBean.tel}" />
						<br/>
		
						<label>登山經驗：</label>
						<input type="text" id="exp" name="exp" value="${MemberBean.exp}" />
						<br/>
						
						<div style="display:none">
							<label>會員身分組：</label>
							<input type="text" id="groupId" name="groupId" readonly="readonly" value="${MemberBean.groupId}" />			
							<br/>
						</div>
		
		
<!-- 						<label>購物車購買總額：</label> -->
<%-- 						<span><c:out value="${MemberBean.totalAmount}" /></span> --%>
<!-- 						<br/> -->
							
<!-- 						<label>未付款總額：</label> -->
<%-- 						<span><c:out value="${MemberBean.Unpaid_amount}" /></span> --%>
<!-- 						<br/> -->
				</fieldset>

				<div>
					<input type="submit" id="update" name="update" value="儲存">
					<input type="reset" id="reset" name="reset" value="還原">
				</div>
			
			</form>
		
		
		</div>
	
	
	
	
	
	
	
	
	</div>



</body>
</html>