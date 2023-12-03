<%-- 
    Document   : error404
    Created on : 3 dic 2023, 16:13:17
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link rel="stylesheet" href="../estilos/error_styles.css"/>
    </head>
    <body>
        <h1>Error encontrado</h1>
        <h2>${requestScope.error}</h2>
    </body>
</html>
