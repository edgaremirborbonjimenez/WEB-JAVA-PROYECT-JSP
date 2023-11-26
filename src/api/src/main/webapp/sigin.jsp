<%-- 
    Document   : sigin
    Created on : Nov 24, 2023, 6:29:31 PM
    Author     : edemb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>sigin</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='style.css'>
</head>
<body>
    <header>
        <span class="id">Feizbuk</span>
    </header>
    <main>
        <div class="txtIS">Crear Sesión</div>
        <div class="txt">Email:</div>
        <div class="inputDiv"><input class="input" type="text"></div>
        <div class="txt">Contraseña:</div>
        <div class="inputDiv">
            <input id="psw" class="input" type="password"><br>
            <input id="chck" type="checkbox">Mostrar Contraseña
        </div>
        <button onclick="muestraMensaje()">Crear Sesión</button><br>
        <div class="a">
            <a href="./login.html">¿ya tienes cuenta? haz click aquí</a>
        </div>
    </main>
    <script src='sign.js'></script>
</body>
</html>