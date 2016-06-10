<%@page import=" br.com.jdbc.ClienteDAO"%>


<%@page import=" br.com.beans.Cliente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String snome = request.getParameter("nome");
String slogin = request.getParameter("login");
String ssenha = request.getParameter("senha");


Cliente cli = new Cliente();
cli.setNome(snome);
cli.setLogin(slogin);
cli.setSenha(ssenha);

ClienteDAO cliDAO = new ClienteDAO();
cliDAO.cadastro(cli);
%>

<h1> Cadastro Efetuado com sucesso! </h1>
</body>
</html>