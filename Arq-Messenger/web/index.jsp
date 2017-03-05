<%-- 
    Document   : index
    Created on : Mar 5, 2017, 12:29:19 AM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Messenger</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </head>
    <body>
        <h1 class="text-center">Red Social</h1>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-4 col-sm-offset-4">
                <ul class="nav nav-tabs nav-justified" role="tablist">
                    <li role="presentation" class="active">
                        <a href="#ingresar" aria-controls="ingresar" role="tab" data-toggle="tab">Ingresar</a>
                    </li>
                    <li role="presentation">
                        <a href="#registrar" aria-controls="registrar" role="tab" data-toggle="tab">Registrar</a>
                    </li>
                </ul>
                <div class="tab-content panel">
                    <div role="tabpanel" class="tab-pane active panel-body" id="ingresar">
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Correo</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="user">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Contraseña</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pwd">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Recordarme
                                </label>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                            </div>
                        </form>
                    </div>
                    <div role="tabpanel" class="tab-pane panel-body" id="registrar">
                        <form action="CreateAccountServlet" method="post">
                            <div class="form-group">
                                <label for="nombreTxt">Nombre</label>
                                <input type="text" class="form-control" id="nombreTxt" placeholder="nombre" name="userR">
                            </div>
                            <div class="form-group">
                                <label for="correoTxt">Correo</label>
                                <input type="email" class="form-control" id="correoTxt" placeholder="Email"  name="emailR">
                            </div>
                            <div class="form-group">
                                <label for="passwordTxt">Contraseña</label>
                                <input type="password" class="form-control" id="passwordText" placeholder="Password" name="pwdR">
                            </div>
                            <div class="form-group">
                                <label for="passwordConfirmTxt">Confirmar Contraseña</label>
                                <input type="password" class="form-control" id="passwordText2" placeholder="Password" name="pwd2R">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
