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
String userEmail = null;
Integer currentID = null; 
List<UserConversation> convs = null;
List<User> users = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userEmail = cookie.getValue();
}
    UserHandler userH = new UserHandler();
    ConversationHandler convH = new ConversationHandler();
    User current =  userH.searchByEmail(userEmail);
    users = userH.AllUsers();
    currentID = current.getId();
    convs = convH.searchAllConvsByUserID(currentID);
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
                               out.print("<a href="+ "\" # \"" +"class="+"\"list-group-item\""+">" + users.get(i).getName()+ "</a>"); 
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
                                   out.print("<P>" + convs.get(i).getNombreConversacion() + "</p>"); 
                                }  
                             %>
                        </div>
                    </div>
                    
                </div>
            </div>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Hola <%=userEmail %> con id <%=currentID%> </a>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="LogoutServlet" method="post">
                    <input type="submit" value="Logout" >
                    </ul>
                </div>
            </nav>

        </div>
    </body>
</html>
