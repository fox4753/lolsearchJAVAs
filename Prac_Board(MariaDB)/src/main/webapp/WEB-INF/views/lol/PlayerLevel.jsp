<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/Playerinfo.css?ver=47"  type="text/css">
<script src="https://kit.fontawesome.com/80d7e22673.js" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 

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
	<h1>${info[st.index].kills }</h1>
	<h1>${info[st.index].deaths }</h1>
	<h1>${info[st.index].assists }</h1>
	<h1>${summoner.name }님 환영합니다.</h1>
	<h1>소환사 레벨입니다</h1>
	<h1>${summoner.level }</h1>
	-->
	<h3>${summoner.name }님 환영합니다.</h3>
		<!-- 로테이션 -->
		<img alt="아이콘" src=${iconURL } class="main-icon-img" >
				<div class="main-div">
				<c:forEach items="${info}" var="matchHistory" varStatus="st">
				<div class="match-content"> 
					<c:if test="${info[st.index].winlose eq 'true'}">
					<div class="match-content-win">
					<div class="match-content-winlose">
							<span class="win">승리</span>
					</div>
					
					
					<div class="match-content-chaminfo">
						<img alt="아이콘" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/champion/${info[st.index].chamName}.png" class="match-content-chamimg" >
					</div>
					
					<div class="match-content-kda">
						<span class="kill">		${info[st.index].kills} / </span>
						<span class="death">	${info[st.index].deaths } /</span>
						<span class="assist">	${info[st.index].assists }</span>
					</div>
					
					<div class="match-content-icondiv">
					<div class="itemlist">
        			<c:choose> 
					<c:when test="${info[st.index].item0 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item0}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					 
					 <c:choose> 
					<c:when test="${info[st.index].item1 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item1}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item2 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item2}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item6 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item6}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item3 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item3}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item4 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item4}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item5 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item5}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
								<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					
					
				
      				

					</div>
					</div>
					</div>
					</c:if>
					
					<c:if test="${info[st.index].winlose eq 'false'}">
					<div class="match-content-lose">
					<div class="match-content-winlose">
							<span class="lose">패배</span>
					</div>
					
					
					<div class="match-content-chaminfo">
						<img alt="아이콘" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/champion/${info[st.index].chamName}.png" class="match-content-chamimg" >
					</div>
					
					<div class="match-content-kda">
						<span class="kill">		${info[st.index].kills} / </span>
						<span class="death">	${info[st.index].deaths } /</span>
						<span class="assist">	${info[st.index].assists }</span>
					</div>
					
					<div class="match-content-icondiv">
					<div class="itemlist">
        			<c:choose> 
					<c:when test="${info[st.index].item0 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item0}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					 
					 <c:choose> 
					<c:when test="${info[st.index].item1 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item1}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item2 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item2}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item6 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item6}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item3 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item3}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item4 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item4}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
							<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>
					
					<c:choose> 
					<c:when test="${info[st.index].item5 ne '0' }">
						<div class="item">
							<img alt="item" src="http://ddragon.leagueoflegends.com/cdn/12.3.1/img/item/${info[st.index].item5}.png"  class="match-content-itemicon" >
						</div>	 
        			</c:when>
					<c:otherwise> 
						<div class="item">
								<img alt="blank" src="resources/img/blank.png" class="match-content-itemicon">
						</div>	
					</c:otherwise> 
					</c:choose>

						
					</div>
					</div>
					</div>
					</c:if>
				</div>
				
			
						
				</c:forEach>
				</div>
	
	
	




</body>
</html>