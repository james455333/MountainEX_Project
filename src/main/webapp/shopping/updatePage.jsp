<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>��x��ƺ��@�t��</title>
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
		<!-- �ޤJ�@�P���� -->
		<jsp:include page="../fragment/backTopNav.jsp"></jsp:include>



	</div>

	<hr>
	<hr>
	<FORM ACTION="ProductUpdateServlet">
		�ק����: <INPUT TYPE="text" NAME="price"> <br> �ק�w�s�q: 
		<INPUT TYPE="text" NAME="stock"> <INPUT TYPE="SUBMIT" VALUE="�ק�">



	</FORM>
</body>
</html>