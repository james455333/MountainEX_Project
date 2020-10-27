<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>��x��ƺ��@�t��/�s�����/[�s�W]]</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../../backstage/css/backStage.css"> 
<link rel="stylesheet" href="bakcMountain.css">
</head>
<body>
	<div id="container1">
		<!-- �ޤJ�@�P���� -->
		<jsp:include page="../../fragment/backTopNav.jsp"></jsp:include>
		
		<%-- <c:forEach var="peakName" items="${mountainBean}" varStatus="vs">
		</c:forEach> --%>
		<c:if test="${ !empty errorMsg}">
			<script type="text/javascript" charset="UTF-8">
				alert("${errorMsg}")
			</script>
		</c:if>
		
		<form action="RouteDataServlet" class="newDataForm">
			<div>
				<label for="npName">* ��a����W�� : &nbsp&nbsp</label>			
				<input type="text" name="npName">
			</div>
			<div>
				<label for="routeName">* ���u�W : &nbsp&nbsp</label>			
				<input type="text" name="routeName">
			</div>
			<div>
				<label for="routeImg">���u���ɮ� : &nbsp&nbsp �|����@</label>			
				<!-- <input type="file" name="routeImg"  accept="image/*" value="�|����@" readonly> -->
			</div>
			<div >
				<label for="routeDesp">* ���u���� : &nbsp&nbsp</label>			
				<textarea rows="2.5%" cols="150%" name="routeDesp" class="bigText"></textarea>
			</div>
			<div >
				<label for="routeAdvice">* ��ĳ���u : &nbsp&nbsp</label>			
				<textarea rows="2.5%" cols="150%" name="routeAdvice" class="bigText"></textarea>
			</div>
			<div >
				<label for="routeTraffic">* ��q��T : &nbsp&nbsp</label>			
				<textarea rows="2.5%" cols="150%" name="routeTraffic" class="bigText"></textarea>
			</div>
			<div id="new_confirm">
				<div>
					<input type="submit" name="mOrder"value="�T�{�s�W">
				</div>
				<div>
				<input type="reset" value="�M��">
				</div>
			</div>
		</form>
			
		
	</div>
	

</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="backMountain.js"></script>
</html>