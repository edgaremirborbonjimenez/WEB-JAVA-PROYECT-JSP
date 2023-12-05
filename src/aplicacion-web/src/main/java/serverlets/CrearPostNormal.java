/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package serverlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.interfaces.Persistencia;
import domain.Comun;
import domain.Normal;
import fachada.FachadaPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edemb
 */
@WebServlet(name = "CrearPostNormal", urlPatterns = {"/CrearPostNormal"})
public class CrearPostNormal extends HttpServlet {

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
            out.println("<title>Servlet CrearPostNormal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearPostNormal at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

        System.out.println(" titulo: " + titulo);
        System.out.println(" contenido: " + contenido);
        Persistencia p = new FachadaPersistencia();
        HttpSession session = request.getSession();
        Normal usuarioNormal = (Normal) session.getAttribute("usuarioNormal");
        Comun comun = new Comun();
        comun.setTitulo(titulo);
        comun.setUsuario(usuarioNormal);
        comun.setFechaHoraCreacon(new Date());
        comun.setContenido(contenido);
        try {
            p.crearPostComun(comun);
        } catch (Exception ex) {
            Logger.getLogger(CrearPostAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(usuarioNormal.getId());

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
