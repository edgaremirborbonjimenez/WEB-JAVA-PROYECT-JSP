<%-- 
    Document   : login-admin
    Created on : Dec 4, 2023, 10:52:55 PM
    Author     : edemb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>login</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='style.css'>
</head>
<body>
    <header>
        <span class="id">Feizbuk</span>
    </header>
    <main class="login">
        <form method="post" action="LoginAdmin">
        <div class="txtIS">Iniciar Sesión como Admin</div>
        <div class="txt">Email:</div>
        <div class="inputDiv"><input name="email" class="input" type="text"></div>
        <div class="txt">Contraseña:</div>
        <div class="inputDiv">
            <input name="password" id="psw" class="input" type="password"><br>
            <input id="chck" type="checkbox">Mostrar Contraseña
        </div>
        <input class="button" type="submit" value="Iniciar Sesión"><br>
        <div class="a">
            <a href="http://localhost:8080/aplicacion-web/login.jsp">iniciar sesion como Normal</a><br>
            <a href="http://localhost:8080/aplicacion-web/sigin.jsp">¿no tienes cuenta? haz click aquí</a>
        </div>
        </form>
    </main>
    <script src='login.js'></script>
</body>
</html>
