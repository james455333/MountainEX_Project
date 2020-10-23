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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
<style>
 .moup {
            position: relative;
            margin: 2%;
            /* margin-left: %;
     margin-top: 10%; */
            /* background-color: aqua; */
            width: 20%;
            float: left;
	clear:right;
	
        }
       .look{
       margin:2%;
      
       float:right;
       }
       .cow{
        margin:1%;
        float: left;
        clear:left;
        margin-left:30%;
        }
</style>
</head>

<body>

<c:set var='functionCheck'  value="mountainhouse" scope="session"/>


	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
		
		<div id="barNav"></div>
			<form action="<c:url value='InsertCampServlet'></c:url>"method='post'>	
		<fieldset class="cow" >
		<legend><caption><h2>新增露營區</h2></legend>
		<div><label>縣市</label>
		<input type="text" name="cit" size="10" placeholder="高雄市" value="高雄市">
	</div><div><label>鄉鎮</label>
		<input type="text" name="cmpt" size="10" placeholder="鳳山區" value="鳳山區">
	</div><div>	<label>營地名稱</label>
		<input type="text" name="cmpn" size="20" placeholder="害你好露營區" value="害你好露營區">
	</div><div>	<label>網址</label>
		<input type="text" name="cmpd" size="50" placeholder="https://evshhips.pixnet.net/blog" value="https://evshhips.pixnet.net/blog">
	
	<div><input type="submit" value="新增" onclick="insert_OK()"></div>
		</fieldset>
		
		
	</form>
        
    
    
		</div>

		<footer> 
		
		</footer>

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
	function insert_OK(){
		alert("新增成功")
	}
	</script>
		
		
</body>

</html>