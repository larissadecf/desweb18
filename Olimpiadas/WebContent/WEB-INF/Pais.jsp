<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.Pais" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pais</title>
</head>
<body>

	<%Pais pais = (Pais)request.getAttribute("Pais"); %>>
	Id: <%=pais.getId() %> </br>
	Nome: <%=pais.getNome() %> </br>
	Populacao: <%=pais.getPopulacao() %> </br>
	area: <%=pais.getArea() %> </br>
	
</body>
</html>