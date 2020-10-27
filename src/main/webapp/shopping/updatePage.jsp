<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>後台資料維護系統</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/backStage.css">
</head>
<body>
	<div id="container1">
		<!-- 引入共同頁首 -->
		<jsp:include page="../fragment/backTopNav.jsp"></jsp:include>



	</div>

	<hr>
	<hr>
	<FORM ACTION="ProductUpdateServlet">
		修改價格: <INPUT TYPE="text" NAME="price"> <br> 修改庫存量: 
		<INPUT TYPE="text" NAME="stock"> <INPUT TYPE="SUBMIT" VALUE="修改">



	</FORM>
</body>
</html>