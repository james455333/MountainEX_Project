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

	</FORM>
	<FORM ACTION="ProductQueryServlet">
		�d�߶���: <INPUT TYPE="button" NAME="firstclass" VALUE="�ӫ~�D���O"> <INPUT
			TYPE="button" NAME="secondclass" VALUE="�ӫ~�����O"> <INPUT
			TYPE="button" NAME="itembasic" VALUE="�ӫ~�򥻸��"> <INPUT
			TYPE="button" NAME="iteminfo" VALUE="�ӫ~��T">



	</FORM>
	<hr>
	<hr>
	<a href='<c:url value="/shopping/insertPage.jsp" />'>�s�W�@���ӫ~��T</a>
	<hr>

	<table border='1'>
		<tr width="100%">
			<th width='5%' align='center'>���~�s��</th>
			<th width='20%' align='center'>���~�W</th>
			<th width='5%' align='center'>����</th>
			<th width='5%' align='center'>����</th>
			<th width='25%' align='center'>�Ϥ�</th>
			<th width='25%' align='center'>�ԭz</th>
			<th width='5%' align='center'>������</th>
			<th width='5%' align='center'>�w�s</th>
			<th width='5%' align='center'>�D����</th>
			<th>�R��</th>
			<th>�ק�</th>
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
			<td><a href='<c:url value="/shopping/updatePage.jsp" />'>�ק�</a></td>
			<FORM ACTION="ProductDeleteServlet">
				<td><INPUT NAME="${aProductBean.name}" TYPE="SUBMIT" VALUE="�R��">
			</FORM>
			</td>
			</tr>
		</c:forEach>
</body>
</html>