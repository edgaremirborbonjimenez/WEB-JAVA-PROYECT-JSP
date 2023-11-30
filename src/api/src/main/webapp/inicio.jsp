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
		<button class="p">¡Vamos pública algo, haz clic aqui!</button>

		<form action="">
			<div class="f">
				<h3>De: Roberto</h3>
				<img class="basura" src="https://cdn3.iconfinder.com/data/icons/user-interface-169/32/trash-512.png">
			</div>
                        <% System.out.println(request.getSession().toString()); 
                            System.out.println("Me cago en la puta. YAAAAAaa");
                        %>
			<h5>mi primera publicacion</h5>
			<p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
				quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
				consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
				cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
				proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</p>
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
    </body>
</html>
