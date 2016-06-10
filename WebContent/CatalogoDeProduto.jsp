<%@page import="java.util.List"	 %>
<%@page import="br.com.beans.Produto"	 %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>
<%
List<Produto> listaResultado = (List<Produto>)request.getAttribute("lista");

%>
<table border="1" style="width:100%" >
<tr >
<th>ID Produto</th>
<th>Descrição</th>
<th>Preço</th>


<%
for(Produto p:listaResultado){
%>
<tr>
<th><%=p.getId() %></th>
<th><%=p.getDescrição() %></th>	
<th><%=p.getPreço() %></th>	
<% 	
}
%>
</table>

</body>
</html>