<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/lolmain.css?ver=32"  type="text/css">
</head>
<body>


<nav class="navbar navbar-blue bg-dark">
<div class="container-fluid">
	<!-- navbar -->
	<a class="navbar-brand " href="/lolmain"><img alt="logo" src="resources/img/logo.png"></a>
	<form action="/SummonerInfo">
		<div class="input-group justify-content-end">
  			<input type="text" class="input " placeholder="닉네임을 입력해주세요" name="sname">
  			<button class="btn btn-outline-secondary  btn-light" type="submit" >
  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  				<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/></svg>
  			</button>
		</div>
	</form>
</div>
</nav>
	<!-- main -->
	<div class="mb-5"></div>
	<!-- 로테이션 -->
	

		<div class="card w-50 rotat">
			<div class="card-header rotatnav "> 이번주 로테이션  ( ${rotatTime} ~ ${rotatendTime } ) </div>
  			<div class="card-body">
				<div class="row row-cols-col-4">
				<c:forEach items="${info}" var="infocham" varStatus="st">

						<div class="rotation">
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/${info[st.index].id}.png"  class="chamimg" >
    					<br><b class="chamName">${info[st.index].name}</b>
						</div>
					
						
    			</c:forEach>
    		</div>
    	</div>
	</div>

	<script>
	
	
	
	</script>
</body>
</html>