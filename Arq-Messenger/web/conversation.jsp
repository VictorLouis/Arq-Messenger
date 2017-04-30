<%-- 
    Document   : conversation
    Created on : 5/03/2017, 11:21:28 PM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Business.Logic.MessageHandler, Business.Logic.ConversationHandler, DataAccess.Entity.Message, java.util.List"%>
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
        Integer userId = null; 
        String userEmail = null;
        String httpSessID = null;
        String conversationName = null;
        List<Message> msgs = null;
        Integer ConvID = (Integer) request.getAttribute("cid");
        
        session = request.getSession(false);
        if(session != null){
            userId = (Integer) session.getAttribute("userId");
            userEmail = (String) session.getAttribute("userEmail");
            httpSessID = session.getId();
            
            ConversationHandler convH = new ConversationHandler();
            MessageHandler msgH = new MessageHandler();
            msgs = msgH.searchMsgsByConvID(ConvID);
            conversationName = convH.searchConvNameByID(ConvID);
        }
        else{
            response.sendRedirect("index.jsp");
        }
        %>
        <div class="h100">
            <div class="areaMain">
                <div class="areaChat">
                    <div class="panel panel-default">
                        <div class="panel-heading"> <%=conversationName%> </div>
                        <div class="panel-body">
                            <%  
                                for (int i = 0; i < msgs.size(); i++) { 
                                   out.print("<P>" + msgs.get(i).getUserId().getName() + ": " + msgs.get(i).getText() + "</p>");
                                } 
                             %>
                        </div>
                    </div> 
                        <div class="areaMessage">
                        <form action ="SendServlet" method="post" class="form-inline">
                            <input type="hidden" class="form-control" id="example1" value="<%=userId %>" name="idUser">
                            <input type="hidden" class="form-control" id="example2" value="<%=ConvID %>" name="idConv">
                            <input type="text" class="form-control" id="exampleInputAmount" placeholder="Mensaje" name="msg">
                            <button type="submit" class="btn btn-success">Enviar</button>
                        </form>
                </div>
                </div>
                
                <div class="areaContacts">
                    <p>Add Person</p>
                </div>
            </div>            
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Hola <%=userEmail %>, ID de Sesion:  <%=httpSessID%></a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>

