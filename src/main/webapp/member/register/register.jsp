<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- functionCheck 的 value對應值 -->
<!-- 會員註冊 = REG -->
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
<title>岳進者/會員註冊</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="register.css">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
 
 <script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>

</style>

<script type="text/javascript">
    function setFocusToUserId(){
        document.forms[0].mid.focus();
    }
</script>
</head>

<body>

<c:set var='functionCheck'  value="REG" scope="session"/>

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
			<form method="POST" action="./RegisterServletMP">
				<fieldset>
					<legend>註冊資訊</legend>
					<div>
						<label>帳號：</label>
						<input type="text" name="account" id="account" size="20" value="${param.memberId}" class="fieldWidth" placeholder="請輸入帳號" autocomplete="off" onblur="checkName()">
						<span id="acIdsp"></span>
						<br/>
					</div>
					<div>
						<label>密碼：</label>
						<input type="password" name="password" id="password" size="20" value="${param.password}" class="fieldWidth" placeholder="請輸入密碼" onblur="checkPwd()">
						<span id="pwdsp"></span>
					
					</div>
					<div>
						<label>密碼確認：</label>
						<input type="pwdCheck" name="pwdCheck" id="pwdCheck" size="20" class="fieldWidth" placeholder="請再次輸入密碼" onblur="doublePwd()">
						<span id="pwd2sp"></span>
					</div>
					<div>
						<label>姓名：</label>
						<input type="text" name="name" id="name" value="${param.name}" size="20" class="fieldWidth" onblur="checkName()">
						<span id="nmsp"></span>
					</div>				
					<div>
					<label>地址：</label>
					<input type="text" name="address" id="address" size="30">
					</div>
					<div>
						<label>電話：</label>
						<input type="text" name="tel" id="tel" size="20" class="fieldWidth">
						<span id="tlsp"></span>					
					</div>				
					<div>
						<label>Email：</label>
						<input type="email" name="email" id="email" value="${param.email}" size="20" class="fieldWidth" >
						<span id="emailsp"></span>
					</div>				
					<div>
						<label>登山經驗：</label>
						<input type="text" name="exp" id="exp" value="${param.exp}" size="20" class="fieldWidth">
						<span id="expsp"></span>
					</div>
					<div>
						<label>身分組選擇</label>
						<input type="radio" class="groupId" name="groupId" value="100">一般會員
						<input type="radio" class="groupId" name="groupId" value="200">登山嚮導
					</div>				
		<!-- 			<select name="groupId"> -->
		<!-- 				<option value="100">一般會員</option> -->
		<!-- 				<option value="200">登山嚮導</option> -->
		<!-- 			</select> -->
					<br/>
			
			        <div class="register_output">
			        	<div>
			            <input type="submit" name="submit" id="submit" value="送出">
			        	</div>
			        	<div>
			            <input type="reset" name="reset" id="reset" value="清除">
			        	</div>
			        </div>
				
				</fieldset>
		    </form>
			

		</div>

		<footer> 
		
		</footer>

	</div>


	 <script src="../../pan/jsFolder/index.js"></script> 
	<script src="register.js"></script>


		
		
</body>

</html>