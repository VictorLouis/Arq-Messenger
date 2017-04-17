<%-- 
    Document   : LoginSuccess
    Created on : Mar 4, 2017, 9:15:45 PM
    Author     : arqsoft2017i
    page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="DataAccess.DAO.UserConversationDAO, DataAccess.Entity.UserConversation,  java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
<%
String userName = null;
Integer userSessID = null;
session = request.getSession(false);
UserConversationDAO dao = new UserConversationDAO();
List<UserConversation> list = dao.searchConversationsByConvID(1);
String cname = list.get(1).getNombreConversacion();
if(session != null){
    userName = (String) session.getAttribute("name");
    userSessID = (Integer) session.getAttribute("sessionId");
}
else{
    response.sendRedirect("/index.jsp");
}
%>
<h3>Hi <%=userName %>, ID:  Session ID; Login: <%=session.getId()%> successful.</h3>
<%=cname %>
<br>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>
