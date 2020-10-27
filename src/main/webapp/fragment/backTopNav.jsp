<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	<header>後台資料維護系統</header>
		<nav id="navbar1">
			<div><a href="#">會員資料</a></div>
			<div><a href="#">活動紀錄</a></div>
			<div><a href='<c:url value="/mountain/back/RouteDataServlet?mOrder=selectAll"/>'>山岳資料</a></div>
			<div><a href="#">露營地資料</a></div>
			<div><a href="#">山中小屋資料</a></div>
			<div><a href="#">商品資料</a></div>
		</nav>
    
    