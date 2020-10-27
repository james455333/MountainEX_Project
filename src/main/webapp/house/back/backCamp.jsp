<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div id="searchBar">
			<div class="searchAll">
				<form action="<c:url value='DemoCampServletAction'></c:url>"method='post'>		
				<input name="selectAll" type="submit" value="全部觀看">
				</form>
			</div>
			<div  class="searchSelect">
			<form action="<c:url value='DemoCampServletAction'></c:url>"method='post'>	
				<span>縣市 :&nbsp </span>
				<input type="text" name="selectcity"> 
                <input type="submit" value="查詢" >				
				</form>			
			</div>
			<div class="searchSelect">
			<form action="<c:url value='DemoCampServletAction'></c:url>"method='post'>	
				<span>鄉鎮 :&nbsp </span>
				<input type="text" name="selectcamptown"> 
                <input type="submit" value="查詢" >	
                </form>	
			</div >
			<div class="searchName">
				<form action="<c:url value='DemoCampServletAction'></c:url>"method='post'>	
				<span>營地名稱 :&nbsp </span>
				<input type="text" name="selectcampname"> 
                <input type="submit" value="查詢" >	
				</form>
			</div>
		</div>
		<div id="controller">
			<div>
				<form action="">	
				
					<input type="button" src="#" onclick="location.href='backinsercamp.jsp'"  value="新增">		
				</form>
			</div>
			<div>
				<form action="">
					<input type="search" name="searchInsert">
					<input type="button" src="#" value="修改">		
				</form>
			</div>
			<div>
				<form action="">
					<input type="search" name="searchInsert">
					<input type="button" src="#" value="刪除">		
				</form>
			</div>
		</div>
		<div id="mainContainer">
			<table class="table">
				<thead class="thead-light">
					<tr class="a_titleName">
						<th scope="col"><span class="tr_title">編號</span></th>
						<th scope="col"><span class="tr_title">縣市</span></th>
						<th scope="col"><span class="tr_title">鄉鎮</span></th>
						<th scope="col"><span class="tr_title">營地名稱</span></th>
						<th scope="col"><span class="tr_title">網址</span></th>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach var="i" items="${camp_all}">
				    <tr >	
				      <td>${i.campid}</td>			      
				      <td>${i.city}</td>
				      <td>${i.camptown}</td>
				      <td> ${i.campname}</td>
				      <td><a href="${i.campdesc}">${i.campdesc}</a></td>   
				    </tr>
				 </c:forEach>
				 
				 <c:forEach var="j" items="${camp_city}">
				    <tr >	
				      <td>${j.campid}</td>		      
				      <td>${j.city}</td>
				      <td>${j.camptown}</td>
				      <td> ${j.campname}</td>
				      <td><a href="${j.campdesc}">${j.campdesc}</a></td>   
				    </tr>
				 </c:forEach>
				 
				 <c:forEach var="k" items="${camp_camptown}">
				    <tr >
				      <td>${k.campid}</td>			      
				      <td>${k.city}</td>
				      <td>${k.camptown}</td>
				      <td> ${k.campname}</td>
				      <td><a href="${k.campdesc}">${k.campdesc}</a></td>   
				    </tr>
				 </c:forEach>
				 
				 <c:forEach var="l" items="${camp_campname}">
				    <tr >	
				      <td>${l.campid}</td>		      
				      <td>${l.city}</td>
				      <td>${l.camptown}</td>
				      <td> ${l.campname}</td>
				      <td><a href="${l.campdesc}">${l.campdesc}</a></td>  
				      <td>
				      <form  action="<c:url value='DemoCampServletAction'></c:url>"method='post'>
				      <input type="hidden" name="deletecampid" value="${l.campid}">
				      <input type="submit" name="deletecamp" value="刪除" >
				      </form>
				      </td> 
				    
				   <td>
				    		<form  action="<c:url value='DemoCampServletAction'></c:url>"method='post'>	
				    		<input type="text" name="updatacamp_id" size="10" value="${l.campid}">				    		
				    		<input type="text" name="updatecamp_city" size="10" value="${l.city}">
				    		<input type="text" name="updatecamp_town" size="10" value="${l.camptown}">
				    		<input type="text" name="updatecamp_name" size="20" value="${l.campname}">
				    		<input type="text" name="updatecamp_desc" size="50" value="${l.campdesc}">
				    	<input type="submit" name="updatecamp" value="修改">
				    	</form>
				   </td>
				   </tr>
				 </c:forEach>
				 
			</table>
		</div>
		
	</div>

</tbody>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="backMountain.js"></script>
</html>