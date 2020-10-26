<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>��x��ƺ��@�t��/�s�����</title>
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
		
		<div id="searchBar">
			<form action="RouteDataServlet" method="get" class="scopeQuery">
				<div  class="searchSelect">
					<span>��a���� :&nbsp</span>
					<select name="nationalPark" id="nPSelect">
						<c:forEach var="npBean" items="${npBean}" varStatus="vs">
							<option value="${npBean.id}">${npBean.name}</option>
						</c:forEach>
					</select>			
				</div>
				<div class="searchSelect">
					<input type="submit" name="mOrder" value="��a����d��">
				</div>
			</form>
			<form action="RouteDataServlet" method="get" class="scopeQuery">
				<div class="searchSelect">
					<span>���u�W�� :&nbsp</span>
					<c:forEach var="npBean" items="${npBean}" varStatus="vsNP" >
						<c:choose>
							<c:when test="${vsNP.first}">
								<select name="route" class="route" >
									<c:forEach var="peakBean" items="${mountainBean}" varStatus="vsRT">
										<c:if test="${ peakBean.npName == npBean.name}">
											<option value="${peakBean.seqno}">${peakBean.name}</option>
										</c:if>	
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name="route" class="route" style="display: none;" >
									<c:forEach var="peakBean" items="${mountainBean}" varStatus="vsRT">
										<c:if test="${ peakBean.npName == npBean.name}">
											<option value="${peakBean.seqno}">${peakBean.name}</option>
										</c:if>	
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div >
				<div class="searchSelect">
					<input type="submit" name="mOrder" value="�S�w���u�d��">
				</div>
			</form>
			
			<div class="searchAll">
				<form>
				<input type="search" name="search1">
				<input type="submit" value="�j�M">
				</form>
			</div>
		</div>
		<div id="controller">
			<div>
				<input type="button" src="#" value="�s�W">		
			</div>
			<div>
				<form action="">
					<input type="search" name="searchInsert">
					<input type="button" src="#" value="�ק�">		
				</form>
			</div>
			<div>
				<form action="">
					<input type="search" name="searchInsert">
					<input type="button" src="#" value="�R��">		
				</form>
			</div>
		</div>
		<div id="mainContainer">
			<table class="table">
				<thead class="thead-light">
					<tr class="a_titleName">
						<th scope="col"><span class="tr_title">���u�s��</span></th>
						<th scope="col"><span class="tr_title">���u�W��</span></th>
						<th scope="col"><span class="tr_title">��a����W��</span></th>
						<th scope="col"><span class="tr_title">���u�w����</span></th>
						<th scope="col"><span class="tr_title">���u����</span></th>
						<th scope="col"><span class="tr_title">��ĳ���u</span></th>
						<th scope="col"><span class="tr_title">��q��T</span></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="peakName" items="${mainBean}" varStatus="vs">
				    <tr >
				    	<th>${peakName.seqno}</th>
				    	<td>${peakName.name}</td>
				    	<td>${peakName.npName}</td>
				    	<td><img style="width:250px;height:250px;"src="../images/${peakName.imgUrl}"></td>
				    	<td><div style="width:250px;height:200px;overflow: scroll;overflow-x:hidden;">${peakName.description}</div></td>
				    	<td><div style="width:250px;height:200px;overflow: scroll;overflow-x:hidden;">${peakName.advice}</div></td>
				    	<td><div style="width:250px;height:200px;overflow: scroll;overflow-x:hidden;">${peakName.traffic}</div></td>
				    </tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
	

</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="backMountain.js"></script>
</html>