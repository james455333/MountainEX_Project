<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- functionCheck 的 value對應值 -->
<!-- 會員登入 = logging -->
<!-- 會員資料 = memberInfo -->
<!-- 資料維護 = maintainInfo -->
<!-- 百戰百岳 = mountain -->
<!-- 露營地/山中小屋 = house -->
<!-- 購物商城 = shopping -->
<!-- 討論區 = platform -->

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>露營地/山中小屋</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../../pan/cssFolder/index.css">
<style>
.moup {
	position: relative;
	margin: 3% 3% 0% 5%;
	/* margin-left: %;
     margin-top: 10%; */
	/* background-color: aqua; */
	width: 15%;
	float: left;
	clear: right;
}

.cow {
	margin: 1%;
	float: left;
	clear: left;
	margin-left: 30%;
	
}

td, th {
	padding: 10px;
	text-align: center;
	border:1px solid black;
}
</style>
</head>

<body>

	<c:set var='functionCheck' value="house" scope="session" />


	<div id="container">

		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />


		<!-- 主要內容 -->
		<div id="content">
			<form action="<c:url value='CampServlet'></c:url>" method='post'>
				<div class="moup">
					<div class="search">
						
						<input type="submit" value="全部查詢">
					</div>
				</div>
			</form>

			<form action="<c:url value='SelectCampCityServlet'></c:url>" method='post'>
				<div class="moup">
					<div class="search">
						<label>城市</label> 
						<input type="text" name="sc" class="form-control" tabindex="28"> 
						<input type="submit"value="查詢">
					</div>
				</div>
			</form>
			<form action="<c:url value='SelectCampTownServlet'></c:url>"
				method='post'>
				<div class="moup">
					<div class="search">
						<label>鄉鎮</label> 
						<input type="text" name="st" class="form-control" tabindex="28"> 
						<input type="submit" value="查詢">
					</div>
				</div>
			</form>

			<form action="<c:url value='SelectCampNameServlet'></c:url>"
				method='post'>
				<div class="moup">
					<div class="search">
						<label>營地名稱</label> <input type="text" name="sn"
							class="form-control" tabindex="28"> <input type="submit"
							value="查詢">
					</div>
				</div>
			</form>

	<%-- 		<c:if test="${ !empty LoginOK}"> --%>
				<div>
					<input type="button" onclick="location.href='insertcamp.jsp'" value="新增">
				</div>
	<%-- 		</c:if> --%>


			<table class="cow">
				<thead>
					<tr>
						<th>縣市</th>
						<th>鄉鎮</th>
						<th>營地名稱</th>
						<th>網址</th>
					</tr>
				</thead>
				<body>
					<div class="cow">
						<c:forEach var="i" items="${camp_all}">
							<tr>
								<p>
								<td>${i.city}</td>
								<td>${i.camptown}</td>
								<td>${i.campname}</td>
								<td><a href="${i.campdesc}">${i.campdesc}</a></td>
								</p>
							</tr>

						</c:forEach>

					</div>

					<div class="cow">
						<c:forEach var="k" items="${camp_city}">
							<tr>
								<p>
								<td>${k.city}</td>
								<td>${k.camptown}</td>
								<td>${k.campname}</td>
								<td><a href="${k.campdesc}"> ${k.campdesc} </a></td>
								</p>
							</tr>
						</c:forEach>

					</div>

					<div class="cow">

						<c:forEach var="j" items="${camp_town}">
							<tr>
								<p>
								<td>${j.city}</td>
								<td>${j.camptown}</td>
								<td>${j.campname}</td>
								<td><a href="${j.campdesc}"> ${j.campdesc} </a></td>
								</p>
							</tr>
						</c:forEach>

					</div>
					<div class="cow">

						<c:forEach var="l" items="${camp_name}">
							<tr>
								<p>
								<td>${l.city}</td>
								<td>${l.camptown}</td>
								<td>${l.campname}</td>
								<td><a href="${l.campdesc}"> ${l.campdesc} </a></td>
					<%-- 			<c:if test="${ !empty LoginOK }"> --%>
									<td>
										<form action="<c:url value='DeleteCampServlet'></c:url>" name="form1" method='post'>
											<input class="del" type="hidden" name="delete"	value="${l.campname}"> 
											<input type="button" onclick="return delete_data()" value="刪除">
										</form>
									</td>

									<td>
										<button id="preview">修改</button>
									</td>
					<%-- 			</c:if> --%>

								</p>
							</tr>

							<div>
								<form action="<c:url value='UpdateCampServlet'></c:url>" method='post' >
									<fieldset class="cow" var="l" items="${camp_name}" >
										<legend>
											<caption id="hideForm" style="display: none;">
												<h2>修改營地</h2>
										</legend>
										<div>
											<label>縣市</label> <input type="text" name="cit1" size="10" value="${l.city}">
										</div>
										<div>
											<label>鄉鎮</label> <input type="text" name="cmpt1" size="10" value="${l.camptown}">
										</div>
										<div>
											<label>營地名稱</label> <input type="text" name="cmpn1" size="20" value="${l.campname}">
										</div>
										<div>
											<label>網址</label> <input type="text" name="cmpd1" size="50" value="${l.campdesc}">
										</div>

										<div>
											<input type="submit" value="修改"><input type="button" value="取消" id="cancel_update">
										</div>
									</fieldset>
								</form>

							</div>


						</c:forEach>

					</div>
				</body>
			</table>



		</div>

		<footer> </footer>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="../../pan/jsFolder/index.js"></script>
	<script id="contentCov"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


	<script>
		$("#preview").on("click", function() {
			console.log($("#hideForm"))
			$("#hideForm").css("display", "block")
		})
		$("#cancel_update").on("click", function() {
			$("#hideForm").css("display", "none")
		})
		function delete_data(){
			if(confirm("確認刪除?"))
				 {
				document.form1.submit();
				return true
				      alert('已删除');			
				 }
				else
				{		return false;
				       alert('取消')
				}
		}
	</script>


</body>

</html>