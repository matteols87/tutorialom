<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World</title>
</head>
<body>
	<c:forEach items="${continents}" var="cont">
		<a href='/MatteoJSPServletExample/countries?continent=${cont}' style="display:block;">${cont}</a>
	</c:forEach>

</body>
</html>