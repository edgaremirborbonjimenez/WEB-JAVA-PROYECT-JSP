
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-MX">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear publicación</title>
        <link rel='stylesheet' type='text/css' media='screen' href='style.css'>

        
    </head>
    <body>
        <%

            // Obtener el estado del usuario desde la sesión
            boolean isAdmor = (boolean)request.getSession().getAttribute("isAdmor");

            // Redirigir a la página correspondiente
            if (!isAdmor) {
                response.sendRedirect("crear-publicacion.jsp");
            }
        %>
        <%@include file="WEB-INF/Header.jspf" %>
        <main class="main">
            <section class="main__section">
                <div class="main__section-container">
                    <form  id="myForm" class="main__section-form" method="POST" >
                            
                        <div class="main__section-form-titulo"> 
                            <label class="main__section-form-titulo-label" for="titulo">Título:</label>
                            
                                <input class="main__section-form-titulo-input" type="text" name="titulo" id="titulo" placeholder="Escribe un título" value="">
                        </div>
                        <div class="main__section-form-contenido">
                            <label class="main__section-form-contenido-label" for="contenido">Contenido:</label>
                                <textarea class="main__section-form-contenido-textarea" name="contenido" id="contenido" cols="30" rows="10" placeholder="¿Qué estás pensando?"></textarea>
                        </div>
                        <div>
                            <input type="checkbox" id="isAnclado">
                        </div>
                        <div class="main__section-form-publicar">
                            <button class="main__section-form-publicar-confirmar" id="btn-guardar-post" type="submit">Publicar</button>
                            <div class="main__section-form-publicar-cancelar" id="btn-cancelar-post"><a href="inicio.jsp">Cancelar</a></div>
                        </div>    
                    </form>
                </div>
            </section>
        </main>
        <script src="crearPublicacionesAdmor.js" type="module"></script>
    </body>
</html>