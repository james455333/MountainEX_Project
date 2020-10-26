<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInfo Backup</title>
</head>
<body>
<c:set var='functionCheck'  value="REG" scope="session"/>
	<div id="container">
<!-- 		引入共同頁首 -->
<%-- 		<jsp:include page=""/> --%>
			
			<div id="content">
				<form id="backupInfo" method="POST" action="<c:url value='MemberBackupServlet' />">
					<h2>會員資料檢索</h2>
					
					<label>總覽：</label>
					<input type="submit" id="selectAll" name="selectAll" value="總表查詢"/>
					
					<label>單筆查詢：</label>
					<input type="text" id="selectSingle" name="selectSingle" placeholder="請輸入會員帳號" autocomplete="off"/>
				
				</form>			
			</div>
			
			<div>
				<table>
				<c:forEach var="info" items="${mbList}">
				
					<tr>
						<td>${info.memberId}</td>
						<td>${info.account}</td>
<%-- 						<td>${info.password}</td> --%>
						<td>${info.name}</td>
						<td>${info.address}</td>
						<td>${info.email}</td>
						<td>${info.tel}</td>
						<td>${info.exp}</td>
						<td>${info.groupId}</td>
						<td>${info.totalAmt}</td>
						<td>${info.unpaid_amount}</td>
						<td>${info.memberImage}</td>					
					</tr>
				
				</c:forEach>
				</table>

			</div>
	
	
	
	
	
	</div>

</body>
</html>