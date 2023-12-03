/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package serverlets;

import dao.interfaces.Persistencia;
import domain.Admor;
import domain.Estado;
import domain.Municipio;
import domain.Normal;
import domain.Usuario;
import fachada.FachadaPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import utils.Utils;

/**
 *
 * @author edemb
 */
@WebServlet(name = "Sigin", urlPatterns = {"/Sigin"})
public class Sigin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processErrorRequest(HttpServletResponse response, String error)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sigin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error " + error + "</h1>");
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
//        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String name = request.getParameter("name");
        String fotoPerfil = request.getParameter("fotoPerfil");
        var birthday = request.getParameter("birthday");
        System.out.println(birthday);
        String genero = request.getParameter("genero");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String municipio = request.getParameter("municipio");
        String estado = request.getParameter("estado");
        String password = request.getParameter("password");
        String admin = request.getParameter("admin");

        if (!Utils.isPasswordValid(password)) {
            processErrorRequest(response, "Contraseña invalida, al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número");
        }else
        if (!Utils.isEmailValid(email)) {
            processErrorRequest(response, "Correo Electronico Invalido");
        }else
        if (!Utils.isNameValid(name)) {
            processErrorRequest(response, "Nombre invalido");
        }else
        if (!Utils.isPhonNumberValid(phone)) {
            processErrorRequest(response, "Numero de telefono invalido");
        }else{

        try {
            Persistencia p = new FachadaPersistencia();
            Usuario u = p.consultarUsuarioByEmail(email);
            if (u == null && !"on".equals(admin)) {
                Normal newUser = new Normal();
                newUser.setNombreCompleto(name);
                newUser.setAvatar(fotoPerfil);
                newUser.setContraseña(password);
                newUser.setCorreo(email);
                newUser.setFechaNacimiento(new Date());
                newUser.setGenero(genero);
                newUser.setCiudad(city);
                newUser.setTelefono(phone);
                newUser.setMunicipio(new Municipio(municipio, new Estado(estado)));
                newUser = p.registrarUsuarioNormal(newUser);
                if (newUser.getId() != null) {
                    response.sendRedirect("/aplicacion-web/login.jsp");
                }
            } else if (u == null && "on".equals(admin)) {
                Admor newUser = new Admor();
                newUser.setNombreCompleto(name);
                newUser.setAvatar(fotoPerfil);
                newUser.setContraseña(password);
                newUser.setCorreo(email);
                newUser.setFechaNacimiento(new Date());
                newUser.setGenero(genero);
                newUser.setCiudad(city);
                newUser.setTelefono(phone);
                newUser.setMunicipio(new Municipio(municipio, new Estado(estado)));
                newUser = p.registrarUsuarioAdmin(newUser);
                if (newUser.getId() != null) {
                    response.sendRedirect("/aplicacion-web/login.jsp");
                }
            }
            response.sendRedirect("/aplicacion-web/sigin.jsp");
        } catch (Exception e) {
            processErrorRequest(response, "SURGIO UN ERROR: " + e.getMessage());
        }
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
