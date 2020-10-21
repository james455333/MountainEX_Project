<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>岳進者</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="pan/cssFolder/index.css">
<style>
</style>
</head>

<body>
<c:set var='functionCheck'  value="none" scope="session"/>
	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
		</div>

		<footer> 
		
		</footer>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="pan/jsFolder/welcome.js"></script> 
	<script src="pan/jsFolder/index.js"></script> 
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
		
</body>

</html>