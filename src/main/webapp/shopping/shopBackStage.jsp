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

	</FORM>
	<FORM ACTION="ProductQueryServlet">
		查詢項目: <INPUT TYPE="button" NAME="firstclass" VALUE="商品主類別"> <INPUT
			TYPE="button" NAME="secondclass" VALUE="商品次類別"> <INPUT
			TYPE="button" NAME="itembasic" VALUE="商品基本資料"> <INPUT
			TYPE="button" NAME="iteminfo" VALUE="商品資訊">



	</FORM>
	<hr>
	<hr>
	<a href='<c:url value="/shopping/insertPage.jsp" />'>新增一筆商品資訊</a>
	<hr>

	<table border='1'>
		<tr width="100%">
			<th width='5%' align='center'>產品編號</th>
			<th width='20%' align='center'>產品名</th>
			<th width='5%' align='center'>型號</th>
			<th width='5%' align='center'>價格</th>
			<th width='25%' align='center'>圖片</th>
			<th width='25%' align='center'>敘述</th>
			<th width='5%' align='center'>次分類</th>
			<th width='5%' align='center'>庫存</th>
			<th width='5%' align='center'>主分類</th>
			<th>刪除</th>
			<th>修改</th>
		</tr>
		<c:forEach varStatus="stVar" var="aProductBean" items="${query}">
			<td width='50' align='center'>${aProductBean.seqno}</td>
			<td width='200' align='center'>${aProductBean.name}</td>
			<td width='100' align='center'>${aProductBean.type}</td>
			<td width='50' align='center'>${aProductBean.price}</td>
			<td width='500' align='center'>${aProductBean.imgUrl}</td>
			<td width='200' align='center'>${aProductBean.description}</td>
			<td width='200' align='center'>${aProductBean.secondClass}</td>
			<td width='40' align='center'>${aProductBean.stock}</td>
			<td align='center'>${aProductBean.firstClassname}</td>
			<td><a href='<c:url value="/shopping/updatePage.jsp" />'>修改</a></td>
			<FORM ACTION="ProductDeleteServlet">
				<td><INPUT NAME="${aProductBean.name}" TYPE="SUBMIT" VALUE="刪除">
			</FORM>
			</td>
			</tr>
		</c:forEach>
</body>
</html>