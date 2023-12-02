<%-- 
    Document   : Inicio
    Created on : 28 nov 2023, 10:11:38
    Author     : JIVB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' media='screen' href='style.css'>
        <link rel='stylesheet' type='text/css' media='screen' href='Publicacion.css'>
        <title>Feizbuk Inicio</title>
    </head>
    <body>
        <%@include file="WEB-INF/Header.jspf" %>
        <main>
            <h2>${requestScope.email}</h2>
            <h2>${requestScope.password}</h2>
		<button class="p">¡Vamos pública algo, haz clic aqui!</button>

		<form action="">
			<div class="f">
                            <h3 id="autor">De: Roberto</h3>
				<img class="basura" src="https://cdn3.iconfinder.com/data/icons/user-interface-169/32/trash-512.png">
			</div>
                    <h5 id="titulo"></h5>
                        <p id="texto"></p>
			<p>comentarios</p>
			<div class="coms">
				<p>Luis:</p>
				<p>Marco:</p>
				<p>Pedro:</p>
				<p>Luisa:</p>
			</div>
			<div class="in">
				<input type="text" id="comentario" placeholder="Escribele un comentario:">
				<button type="button">Envíar</button>
			</div>
		</form>
	</main>
                        <script src="inicio.js"></script>
    </body>
</html>
