<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/lolmain.css?ver=48	"  type="text/css">
<script src="https://kit.fontawesome.com/80d7e22673.js" crossorigin="anonymous"></script>
</head>
<body>


<nav class="navbar navbar-blue bg-dark">
<div class="container-fluid">
	<!-- navbar -->
	<a  href="/lolmain"><img alt="logo" src="resources/img/logo.png" class="nav-logo-img"></a>
	<form action="/SummonerInfo " autocomplete="off">
		<div class="input-group nav-search justify-content-end">
  			<input type="text" class="nav-input " placeholder="닉네임을 입력해주세요" name="sname">
  			<button type="submit" class="nav-input-button" >
  				<i class="fas fa-search"></i>
  				</button>
		</div>
	</form>
</div>
</nav>
	<!-- main -->
	<div class="mb-5"></div>
	
	
	<!-- 로테이션 -->
	

		<div class="rotation-content-index">
			
				<div class="rotation-content-main">
				<div class="rotation-nav"> 이번주 로테이션  ( ${rotatTime} ~ ${rotatendTime } ) </div>
				<c:forEach items="${info}" var="infocham" varStatus="st">

						<div class="rotation">
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/${info[st.index].id}.png"  class="chamimg" >
    					<div class="chamName">${info[st.index].name}</div>
						</div>
					
						
    			</c:forEach>
    		</div>
	</div>
	
	<div class="margin-space">
	
	</div>
	
	<!-- 검색창  -->	
	<div class="searchbar">
			<form action="/SummonerInfo" class=sarchbar-main>
  				<input type="text" class="input-main " placeholder="닉네임을 입력해주세요" name="sname">
  				<button type="submit" class="main-input-button" >
  				<i class="fas fa-search"></i>
  				</button>
  			</form>
	</div>

	<script>
	
	
	
	</script>
</body>
</html>