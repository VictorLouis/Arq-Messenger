<%-- 
    Document   : messenger
    Created on : Mar 5, 2017, 11:20:50 AM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"  import="DataAccess.DAO.UserDAO, DataAccess.Entity.User, java.util.List, DataAccess.Entity.UserConversation, DataAccess.DAO.UserConversationDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Messenger</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </head>
    <body>
        <%
        
            
String userName = null;
Integer currentID = null; 
List<UserConversation> convs = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
UserDAO temp = new UserDAO();
UserConversationDAO temp1 = new UserConversationDAO();
User current =  temp.searchUserByEmail(userName);
currentID = current.getId();
//convs = temp1.searchConversationByUserID(currentID);
}
if(userName == null) response.sendRedirect("index.jsp");
%>
        <div class="h100">
            <div class="areaMain">
                <div class="areaContacts">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">
                            Victor El Pro
                        </a>
                        <a href="#" class="list-group-item">Alex</a>
                        <a href="#" class="list-group-item">Carlos</a>
                        <a href="#" class="list-group-item">Felipe</a>
                    </div>
                </div>
                <div class="areaChat">
                    <div class="panel panel-default">
                        <div class="panel-heading">Usuario1, Usuario2</div>
                        <div class="panel-body">
                           <%  /*
   
   for (int i = 0; i < convs.size(); i++) {
      out.print("<P>" + convs.get(i).getNombreConversacion() + "</p>");
   } */
%>
                        </div>
                    </div>
                    <div class="areaMessage">
                        <form class="form-inline">
                            <input type="text" class="form-control" id="exampleInputAmount" placeholder="Mensaje">
                            <button type="submit" class="btn btn-success">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Hola <%=userName %> con id <%=currentID%> </a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>
