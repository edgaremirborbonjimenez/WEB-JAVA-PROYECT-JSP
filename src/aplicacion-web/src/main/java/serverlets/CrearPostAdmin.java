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
import com.google.gson.JsonObject;
import dao.interfaces.Persistencia;
import domain.Anclado;
import domain.Comun;
import domain.Normal;
import domain.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        Gson gson = new Gson();
        JsonObject jsonBody = gson.fromJson(sb.toString(), JsonObject.class);

        String titulo = jsonBody.get("titulo").getAsString();
        String contenido = jsonBody.get("contenido").getAsString();
        boolean isAnclado = jsonBody.get("isAnclado").getAsBoolean();

        System.out.println(" titulo: " + titulo);
        System.out.println(" contenido: " + contenido);
        Persistencia p = new FachadaPersistencia();
        HttpSession session = request.getSession();
        Admor usuarioAdmin = (Admor) session.getAttribute("usuarioNormal");
        try {
            if (isAnclado) {
                Anclado anclado = new Anclado();
                anclado.setAdmor(usuarioAdmin);
                anclado.setContenido(contenido);
                anclado.setFechaHoraCreacon(new Date());
                anclado.setTitulo(titulo);
                p.crearPostAnclado(anclado);
            } else {
                Comun comun = new Comun();
                comun.setTitulo(titulo);
                comun.setUsuario(usuarioAdmin);
                comun.setFechaHoraCreacon(new Date());
                comun.setContenido(contenido);
                p.crearPostComun(comun);
            }
        } catch (Exception ex) {
            Logger.getLogger(CrearPostAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

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

}
