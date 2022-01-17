<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${summoner.name }님 환영합니다.</h1>
	<h1>소환사 레벨입니다</h1>
	<h1>${summoner.level }</h1>
	<img alt="아이콘" src=${iconURL } >
</body>
</html>