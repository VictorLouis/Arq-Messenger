<%-- 
    Document   : messenger
    Created on : Mar 5, 2017, 11:20:50 AM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"  import="DataAccess.Entity.User, DataAccess.Entity.UserConversation, Business.Logic.ConversationHandler, Business.Logic.UserHandler, java.util.List" %>
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
        String userName = null;
        String httpSessID = null;
        List<UserConversation> convs = null;
        List<User> users = null;
        
        session = request.getSession(false);
        if(session != null){
            userEmail = (String) session.getAttribute("userEmail");
            userId = (Integer) session.getAttribute("userId");
            userName = (String) session.getAttribute("userName");
            httpSessID = session.getId();

            UserHandler userH = new UserHandler();
            ConversationHandler convH = new ConversationHandler();
            User current =  userH.searchByEmail(userEmail);
            users = userH.AllUsers();
            userId = current.getId();
            convs = convH.searchAllConvsByUserID(userId);
        }
        else{
            response.sendRedirect("index.jsp");
        }
        %>
        <div class="h100">
            <div class="areaMain">
                <div class="areaContacts">
                    <div class="list-group">
                        <%  
                            for (int i = 0; i < users.size(); i++) {
                               out.print("<a href='/Arq-Messenger/ClickUserS?currentU="+ userId +"&"+"targetU="+ users.get(i).getId() +"&"+"convN="+ users.get(i).getName() +"'" + "target='_blank'" +"class="+"\"list-group-item\""+">" + users.get(i).getName()+ "</a>"); 
                            }  
                         %>  
                    </div>
                </div>
                <div class="areaChat">
                    <div class="panel panel-default">
                        <div class="panel-heading">Conversaciones</div>
                        <div class="panel-body">
                           <%    
                                for (int i = 0; i < convs.size(); i++) {
                                   out.print("<a href='/Arq-Messenger/ConversationS?cid="+ convs.get(i).getConversation().getId() +"' target='_blank'>" + convs.get(i).getNombreConversacion() + "</a>"); 
                                }  
                             %>
                        </div>
                    </div>
                    
                </div>
                        <div class="areaMessage">
                            <div class="panel-heading">Crear Conversacion</div>
                        <div class="panel-body">
                        <form action ="CreateConversationServlet" method="post" class="form-inline">
                            <input type="text" class="form-control" id="createC1" value="<%=userId %>" name="idUserC">
                            <input type="text" class="form-control" id="createC2" placeholder="targetUser" name="idUserT">
                            <input type="text" class="form-control" id="createC3" placeholder="Nombre" name="nameC">
                            <button type="submit" class="btn btn-success">Crear</button>
                        </form>
                            </div>
                    </div>
            </div>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Hola <%=userName %>, ID de Sesion:  <%=httpSessID%> </a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>
