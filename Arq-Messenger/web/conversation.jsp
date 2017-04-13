<%-- 
    Document   : conversation
    Created on : 5/03/2017, 11:21:28 PM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Business.Logic.MessageHandler, DataAccess.Entity.Message, java.util.List"%>
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
Integer currentID = null; 
String userName = null;
List<Message> msgs = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
MessageHandler msgH = new MessageHandler();
msgs = msgH.searchMsgsByConvID(2);
}
if(userName == null) response.sendRedirect("index.jsp");
%>
        <div class="h100">
            <div class="areaMain">
                <div class="areaChat">
                    <div class="panel panel-default">
                        <div class="panel-heading">Usuario1, Usuario2</div>
                        <div class="panel-body">
                            <%  
   
   for (int i = 0; i < msgs.size(); i++) {
      out.print("<P>" + msgs.get(i).getText() + "</p>");
   } 
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
                    <a class="navbar-brand" href="#">Hola <%=userName %></a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>

