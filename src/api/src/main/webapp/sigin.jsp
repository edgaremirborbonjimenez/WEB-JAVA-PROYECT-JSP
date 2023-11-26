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
        <main class="sigin">
            <form method="post" action="Sigin">
                <div class="txtIS">Crear Sesión</div>
                <div class="txt">Nombre Completo:</div>
                <div class="inputDiv"><input name="name" class="input" type="text"></div>
                <div class="txt">Foto de Perfil:</div>
                <div class="inputDiv"><input name="fotoPerfil" class="input" type="text"></div>
                <div class="txt">Fecha de nacimiento:</div>
                <div class="inputDiv"><input name="birthday" class="input" type="date"></div>
                <div class="txt">Genero:</div>
                <div class="inputDiv"><input name="genero" class="input" type="text"></div>
                <div class="txt">Email:</div>
                <div class="inputDiv"><input name="email" class="input" type="text"></div>
                <div class="txt">Contraseña:</div>
                <div class="inputDiv">
                    <input name="password" id="psw" class="input" type="password"><br>
                    <input id="chck" type="checkbox">Mostrar Contraseña
                </div>
                <div class="txt">Telefono:</div>
                <div class="inputDiv"><input name="phone" class="input" type="text"></div>
                <div class="txt">Ciudad:</div>
                <div class="inputDiv"><input name="city" class="input" type="text"></div>
                <div class="txt">Municipio:</div>
                <div class="inputDiv"><input name="municipio" class="input" type="text"></div>
                <div class="txt">Estado:</div>
                <div class="inputDiv"><input name="estado" class="input" type="text"></div>
                <input class="button" type="submit" value="Crear Sesión"><br>
                <div class="a">
                    <a href="http://localhost:8080/api/login.jsp">¿ya tienes cuenta? haz click aquí</a>
                </div>
            </form>
        </main>
        <script src='sign.js'></script>
    </body>
</html>