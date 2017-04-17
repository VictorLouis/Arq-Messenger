<%-- 
    Document   : conversation
    Created on : 5/03/2017, 11:21:28 PM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="DataAccess.Entity.User, Business.Logic.MessageHandler, Business.Logic.UserHandler, DataAccess.Entity.Message, java.util.List"%>
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

        Integer currentUserID = null; 
        Integer ConvID = 1;
        String userEmail = null;
        List<Message> msgs = null;
        UserHandler userH = new UserHandler();
        session = request.getSession(false);
        if(session != null){
            userEmail = (String) session.getAttribute("name");
            currentUserID = (Integer) session.getAttribute("sessionId");

            User currentUser =  userH.searchByEmail(userEmail);
            currentUserID = currentUser.getId();
            MessageHandler msgH = new MessageHandler();
            msgs = msgH.searchMsgsByConvID(ConvID);
        }
        else{
            response.sendRedirect("index.jsp");
        }
        %>
        <div class="h100">
            <div class="areaMain">
                <div class="areaChat">
                    <div class="panel panel-default">
                        <div class="panel-heading"> CONVERSACION NAME </div>
                        <div class="panel-body">
                            <%  
                                for (int i = 0; i < msgs.size(); i++) { 
                                   out.print("<P>" + msgs.get(i).getUserId().getName() + ": " + msgs.get(i).getText() + "</p>");
                                } 
                             %>
                        </div>
                    </div>
                        <div class="areaContacts">
                            <p>HERE is </p>
                        </div>
                    <div class="areaMessage">
                        <form action ="SendServlet" method="post" class="form-inline">
                            <input type="text" class="form-control" id="example1" value="<%=currentUserID %>" name="idUser">
                            <input type="text" class="form-control" id="example2" value="<%=ConvID %>" name="idConv">
                            <input type="text" class="form-control" id="exampleInputAmount" placeholder="Mensaje" name="msg">
                            <button type="submit" class="btn btn-success">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>            
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Hola <%=userEmail %></a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>

