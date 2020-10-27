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
					<input type="text" id="userId" name="userId" placeholder="請輸入會員帳號" autocomplete="off"/>
					<input type="submit" id="selectOne" name="selectOne" value="送出" />
				
				</form>			
			</div>
			
			<div>
				<table>
				<c:forEach var="info" items="${mbList}">
					<tr>
						<td>${info.memberId}</td>
						<td>${info.account}</td>
<%-- 						<td>${mbList.password}</td> --%>
						<td>${info.name}</td>
						<td>${info.address}</td>
						<td>${info.email}</td>
						<td>${info.tel}</td>
						<td>${info.exp}</td>
						<td>${info.groupId}</td>
						<td>${info.totalAmt}</td>
						<td>${info.unpaid_amount}</td>
						<td>${info.memberImage}</td>
						<td>
							<form id="update1" method="POST" action="<c:url value='MemberBackupServlet' />">
								<input type="text" id="memberIdA" name="memberIdA" readonly="readonly" value="${info.memberId}" />
								<input type="text" id="accountA" name="accountA" value="${info.account}" />
								<input type="password" id="passwordA" name="passwordA" value="${info.password}" />
								<input type="text" id="nameA" name="nameA" value="${info.name}" />
								<input type="text" id="addressA" name="addressA" value="${info.address}" />
								<input type="text" id="emailA" name="emailA" value="${info.email}" />
								<input type="text" id="telA" name="telA" value="${info.tel}" />
								<input type="text" id="expA" name="expA" value="${info.exp}" />
								<input type="text" id="groupIdA" name="groupIdA" value="${info.groupId}" />
								<input type="text" id="totalAmtA" name="totalAmtA" value="${info.totalAmt}" />
								<input type="text" id="unpaid_amountA" name="unpaid_amountA" value="${info.unpaid_amount}" />
<%-- 							<input type="text" id="memberImageA" name="memberImageA" value="${info.memberImage}" /> --%>
								<input type="submit" id="update" name="updateA" value="修改"/>
							</form>
						</td>				
					</tr>
				</c:forEach>
				</table>
			</div>
			<div>
				<table>
				<c:forEach var="infoS" items="${oneList}">
					<tr>
						<td>${infoS.memberId}</td>
						<td>${infoS.account}</td>
<%-- 						<td>${infoS.password}</td> --%>
						<td>${infoS.name}</td>
						<td>${infoS.address}</td>
						<td>${infoS.email}</td>
						<td>${infoS.tel}</td>
						<td>${infoS.exp}</td>
						<td>${infoS.groupId}</td>
						<td>${infoS.totalAmt}</td>
						<td>${infoS.unpaid_amount}</td>
						<td>${infoS.memberImage}</td>
						<td>
							<form id="update1" method="POST" action="<c:url value='MemberBackupServlet' />">
								<input type="text" id="memberIdS" name="memberIdS" readonly="readonly" value="${infoS.memberId}" />
								<input type="text" id="accountS" name="accountS" value="${infoS.account}" />
								<input type="password" id="passwordS" name="passwordS" value="${infoS.password}" />
								<input type="text" id="nameS" name="nameS" value="${infoS.name}" />
								<input type="text" id="addressS" name="addressS" value="${infoS.address}" />
								<input type="text" id="emailS" name="emailS" value="${infoS.email}" />
								<input type="text" id="telS" name="telS" value="${infoS.tel}" />
								<input type="text" id="expS" name="expS" value="${infoS.exp}" />
								<input type="text" id="groupIdS" name="groupIdS" value="${infoS.groupId}" />
								<input type="text" id="totalAmtS" name="totalAmtS" value="${infoS.totalAmt}" />
								<input type="text" id="unpaid_amountS" name="unpaid_amountS" value="${infoS.unpaid_amount}" />
<%-- 							<input type="text" id="memberImageS" name="memberImageS" value="${info.memberImage}" /> --%>
								<input type="submit" id="update" name="updateS" value="修改"/>
							</form>
						</td>					
					</tr>
				</c:forEach>
				</table>
			</div>
			
	</div>		

</body>
</html>