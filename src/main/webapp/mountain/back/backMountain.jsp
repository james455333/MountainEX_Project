<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>後台資料維護系統/山岳資料</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../../backstage/css/backStage.css"> 
<link rel="stylesheet" href="bakcMountain.css">
</head>
<body>
	<div id="container1">
		<!-- 引入共同頁首 -->
		<jsp:include page="../../fragment/backTopNav.jsp"></jsp:include>
		
		<%-- <c:forEach var="peakName" items="${mountainBean}" varStatus="vs">
		</c:forEach> --%>
		<c:if test="${ !empty errorMsg}">
			<script type="text/javascript" charset="UTF-8">
				alert("${errorMsg}")
			</script>
		</c:if>
		<c:if test="${ !empty result}">
			<script type="text/javascript" charset="UTF-8">
				alert("${result}")
			</script>
		</c:if>
		
		<div id="searchBar">
			<form action="RouteDataServlet" method="get" id="scopeQueryNP">
				<div  class="searchSelect">
					<span>國家公園 :&nbsp</span>
					<select name="nationalPark" id="nPSelect">
						<c:forEach var="npBean" items="${npBean}" varStatus="vs">
							<option value="${npBean.id}">${npBean.name}</option>
						</c:forEach>
					</select>			
				</div>
				<div class="searchSelect">
					<input type="submit" name="mOrder" value="國家公園查詢">
				</div>
			</form>
			<c:forEach var="npBean" items="${npBean}" varStatus="vsNP" >
				<c:choose>
					<c:when test="${vsNP.first}">
						<form action="RouteDataServlet" method="get" class="scopeQuery">
							<div class="searchSelect">
								<span>路線名稱 :&nbsp</span>
									<select name="route" class="route" >
										<c:forEach var="peakBean" items="${mountainBean}" varStatus="vsRT">
											<c:if test="${ peakBean.npName == npBean.name}">
												<option value="${peakBean.seqno}">${peakBean.name}</option>
											</c:if>	
										</c:forEach>
									</select>
							</div >
							<div class="searchSelect">
								<input type="submit" name="mOrder" value="特定路線查詢">
							</div>
						</form>
					</c:when>
					<c:otherwise>
						<form action="RouteDataServlet" method="get" class="scopeQuery" style="display: none;">
							<div class="searchSelect">
								<span>路線名稱 :&nbsp</span>
									<select name="route" class="route" >
										<c:forEach var="peakBean" items="${mountainBean}" varStatus="vsRT">
											<c:if test="${ peakBean.npName == npBean.name}">
												<option value="${peakBean.seqno}">${peakBean.name}</option>
											</c:if>	
										</c:forEach>
									</select>
							</div >
							<div class="searchSelect">
								<input type="submit" name="mOrder" value="特定路線查詢">
							</div>
						</form>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 
			<div class="searchAll">
				<form>
				<input type="search" name="search1">
				<input type="submit" value="搜尋">
				</form>
			</div> -->
		</div>
		<div id="controller">
			<div>
				<a href="backMountainNewData.jsp">新增資料</a>	
			</div>
			<div>
				<form action="">
					<input type="search" name="searchInsert" readonly placeholder="尚未實作">
					<input type="submit" name="mOrder" value="修改">		
				</form>
			</div>
			<div>
				<form action="RouteDataServlet">
					<input type="search" name="searchInsert" placeholder="請輸入路線編號">
					<input type="submit" name="mOrder" value="刪除" >		
				</form>
			</div>
		</div>
		<div id="mainContainer">
			<table class="table">
				<thead class="thead-light">
					<tr class="a_titleName">
						<th scope="col"><span class="tr_title">路線編號</span></th>
						<th scope="col"><span class="tr_title">路線名稱</span></th>
						<th scope="col"><span class="tr_title">國家公園名稱</span></th>
						<th scope="col"><span class="tr_title">路線預覽圖</span></th>
						<th scope="col"><span class="tr_title">路線介紹</span></th>
						<th scope="col"><span class="tr_title">建議路線</span></th>
						<th scope="col"><span class="tr_title">交通資訊</span></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="peakName" items="${mainBean}" varStatus="vs">
				    
				    <tr >
				    	<th>${peakName.seqno}</th>
				    	<td>${peakName.name}</td>
				    	<td>${peakName.npName}</td>
				    	<td><img style="width:250px;height:250px;"src="../images/${peakName.imgUrl}" ></td>
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