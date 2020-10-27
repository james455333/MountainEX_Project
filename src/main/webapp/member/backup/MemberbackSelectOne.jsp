<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInfo Backup</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../../backstage/css/backStage.css"> 
<link rel="stylesheet" href="bakcMountain.css">
<style>
	td,th{
		border:1px solid gray;
		text-align:justify;
	}

</style>
</head>

<body>
<c:set var='functionCheck'  value="REG" scope="session"/>
	<div id="container">
<!-- 		引入共同頁首 -->
	<jsp:include page="../../fragment/backTopNav.jsp" />
			
			<div id="content">
				<form id="backupInfo" method="POST" action="<c:url value='MemberBackupServlet' />">
					<h3>會員資料檢索</h3>
					<div>
						<label>總覽：</label>
						<input type="submit" id="selectAll" name="selectAll" value="總表查詢"/>					
					</div>
					<div>
						<label>單筆查詢：</label>
						<input type="text" id="userId" name="userId" placeholder="請輸入會員帳號" autocomplete="off"/>
						<input type="submit" id="selectOne" name="selectOne" value="送出" />					
					</div>
					<div>
			        	<input type="submit" name="submitQ1" id="submitQ1" value="一般會員一鍵註冊">
			        </div>
			        <div>
			        	<input type="submit" name="submitQ2" id="submitQ2" value="登山嚮導一鍵註冊">
			        </div>
				</form>			
			</div>
			<div>
			<form id="update1" method="POST" action="<c:url value='MemberBackupServlet' />">
				<table>
				<c:forEach var="infoS" items="${oneList}">
					<tr>
						<th>會員編號</th>
						<th>會員帳號</th>
<!-- 						<th>會員密碼</th> -->
						<th>會員姓名</th>
						<th>會員地址</th>
						<th>電子郵件</th>
						<th>會員電話</th>
						<th>登山經驗</th>
						<th>會員身分組</th>
						<th>購物總額</th>
						<th>未付款餘額</th>
					</tr>
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
							
								<div style="display:none">
									<input type="text" id="memberIdS" name="memberIdS" readonly="readonly" value="${infoS.memberId}" />
								</div>
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
							</td>
							<td>
								<input type="submit" id="update" name="updateS" value="修改"/>
							
						</td>					
					</tr>
				</c:forEach>
				</table>
			</form>
			</div>
			
	</div>		

</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="backMountain.js"></script>
</html>