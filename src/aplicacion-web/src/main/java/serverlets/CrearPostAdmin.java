/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package serverlets;


import domain.Admor;
import fachada.FachadaPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.google.gson.Gson;
import dao.interfaces.Persistencia;
import domain.Anclado;
import domain.Comun;
import domain.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "CrearPostAdmin", urlPatterns = {"/CrearPostAdmin"})
public class CrearPostAdmin extends HttpServlet {
    
    Persistencia fachadaPersistencia = new FachadaPersistencia();
     Gson serializadorJSON = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearPostAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearPostAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario!=null) {
            System.out.println(usuario.getId());
            System.out.println(usuario.getNombreCompleto());
        }
        
        /*
        var correo = request.getParameter("correo");
        var pass = request.getParameter("pass");
        
        var fachadaPersistenia = new FachadaPersistencia();
        Comun comun = new Comun();
        try {
            var user = fachadaPersistenia.consultarUsuario(correo, pass);
            
            comun.setUsuario(user);
            comun.setContenido(request.getParameter("contenido"));
            comun.setFechaHoraCreacon(new Date());
            comun.setTitulo(request.getParameter("titulo"));
            
        } catch (Exception ex) {          }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if(comun.getId()!=null)
            response.getWriter().write("Publicacion Creada");
        else
            response.getWriter().write("Hubo un problema al crear la publicacion");
        System.out.println(comun.getId());
        System.out.println(comun.getTitulo());
        System.out.println(comun.getContenido());
        System.out.println(comun.getUsuario().getCorreo());
        System.out.println(comun.getFechaHoraCreacon());
        
        response.sendRedirect("Inicio.jsp");
        */
//        if (request.getParameter("correo") != null && request.getParameter("pass") != null)
//            response.getWriter().write("Parámetros recibidos correctamente: correo=" + request.getParameter("correo") + ", id=" + request.getParameter("pass"));
//        else 
//            response.getWriter().write("Error: Faltan parámetros en la solicitud.");
//       if (action != null && action.equalsIgnoreCase("crear-post-anclado")) {
//            this.crearPublicacionAnclado(request, response);
//            return;
//        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void crearPublicacionAnclado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String body = IOUtils.toString(request.getInputStream(), "utf-8");

        HttpSession session = request.getSession();

        Admor admin = (Admor) session.getAttribute("usuario");

        Anclado postAnclado = new Anclado();

        postAnclado.setAdmor(admin);

        try {

            fachadaPersistencia.crearPost(postAnclado);

        } catch (Exception e) {

        }

       String respuestaJson = serializadorJSON.toJson(postAnclado);

        try (PrintWriter out = response.getWriter()) {
            out.write(respuestaJson);
        }
    }

}
