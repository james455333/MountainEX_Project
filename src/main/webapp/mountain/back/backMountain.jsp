<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
		<div id="searchBar">
			<div  class="searchSelect">
				<span>��a���� :&nbsp </span>
				<select name="">
					<option value="">test1</option>
				</select>			
			</div>
			<div class="searchSelect">
				<span>���u�W�� :&nbsp </span>
				<select name="" >
					<option value="">test1</option>
				</select>
			</div >
			<div class="searchAll">
				<form>
				<input type="search" name="search1">
				<input type="submit" value="�j�M">
				</form>
			</div>
		</div>
		<div id="controller">
			<div>
				<form action="">
					<input type="search" name="searchInsert">
					<input type="button" src="#" value="�s�W">		
				</form>
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
				    <tr >
				      <th>1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				      <td>@mdo</td>
				      <td>@mdo</td>
				      <td>@mdo</td>
				    </tr>
			</table>
		</div>
		
	</div>

</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="backMountain.js"></script>
</html>