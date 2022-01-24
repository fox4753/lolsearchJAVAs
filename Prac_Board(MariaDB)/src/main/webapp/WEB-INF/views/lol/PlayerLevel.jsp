<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/Playerinfo.css?ver=17"  type="text/css">
<script src="https://kit.fontawesome.com/80d7e22673.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<!-- 최상단 navbar -->
	
	<nav class="navbar navbar-blue bg-dark">
		<div class="container-fluid">
		<!-- navbar -->
		<a href="/lolmain"><img alt="logo" src="resources/img/logo.png"  class="nav-logo-img"></a>
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
	
	<!-- 메인 헤더 -->
	<div class="header-content">
		<div class="header-content-icon">
		
		</div>
	</div>
	
	
	<!--  
	<h1>${matchdata.kills }</h1>
	<h1>${matchdata.deaths }</h1>
	<h1>${matchdata.assists }</h1>
	<h1>${summoner.name }님 환영합니다.</h1>
	<h1>소환사 레벨입니다</h1>
	<h1>${summoner.level }</h1>
	-->
	<h3>${summoner.name }님 환영합니다.</h3>
		<!-- 로테이션 -->
		<img alt="아이콘" src=${iconURL } class="main-icon-img" >


				
				<div class="match-content"> 
					<div class="match-content-chaminfo">
						<img alt="아이콘" src=${chamicon } class="match-content-chamimg" >
					</div>
					
					<div class="kda">
						<span class="kill">${matchdata.kills } / </span>
						<span class="death">	${matchdata.deaths } /</span>
						<span class="assist">	${matchdata.assists }</span>
					</div>
					
					<div class="match-content-icondiv">
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item0}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item1}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item2}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item6}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item3}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item4}.png"  class="match-content-itemicon" >
						<img alt="rotation" src="http://ddragon.leagueoflegends.com/cdn/12.2.1/img/item/${matchdata.item5}.png"  class="match-content-itemicon" >
					</div>
				</div>

	
	
	
</body>
</html>