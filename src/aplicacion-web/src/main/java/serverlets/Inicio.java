/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package serverlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.interfaces.Persistencia;
import domain.Anclado;
import domain.Comentario;
import domain.Comun;
import domain.Normal;
import domain.Post;
import domain.Usuario;
import fachada.FachadaPersistencia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JIVB
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inicio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inicio at " + request.getContextPath() + "</h1>");
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
        
//        Persistencia p = new FachadaPersistencia();
            
//        try {
//            var user = p.consultarUsuario("ramon@gmail.com", "1234");
//        
//            var comns =new ArrayList<Comentario>();
//            var post = new Comun(user,comns, new Date(),new Date(), "Publicacion de prueba", "en esta publicacion solo sera texto xd");
//            var post2 = new Comun(user,comns,new Date(), new Date(), "Publicacion de numero 2", "ojala tubiera ideas de mas publicaciones para que sea mas largo");
//            var post3 = new Comun(user,comns,new Date(), new Date(), "Publicacion de prueba 3", "soy relleno para hacer mas publicaciones jje");
//            
//            p.crearPostComun(post);
//            p.crearPostComun(post2);
//            p.crearPostComun(post3);
//            p.crearPostComun(post);
//            p.crearPostComun(post2);
//            p.crearPostComun(post3);
//            p.crearPostComun(post3);
//            p.crearPostComun(post3);
//            p.crearPostComun(post2);
//            p.crearPostComun(post2);
//            p.crearPostComun(post);
//            
//        } catch (Exception ex) {
//            
//        }        
        if(request.getSession().getAttribute("usuarioNormal")==null)        
            System.out.println("usuario nullo ");
        enviarRespuestaJson(request, response);

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
        //processRequest(request, response);
        
        Persistencia p = new FachadaPersistencia();
        
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) 
            stringBuilder.append(line);
        
        // Convertir el cuerpo de la solicitud a un objeto JSON
        Gson gson = new Gson();
        JsonObject jsonBody = gson.fromJson(stringBuilder.toString(), JsonObject.class);
        
        
        //se comenta post
        if(jsonBody.get("comentario")!=null)
            try {
                var id = jsonBody.get("id").getAsString();
                var post = p.getPostComunById(Long.valueOf(id));
                System.out.println("Comentara en : "+post.getTitulo());
                var c = new Comentario();
                c.setFechaHora(new Date());
                c.setContenido(jsonBody.get("comentario").getAsString());
                c.setComun(post);
                c.setNormal((Normal)request.getSession().getAttribute("usuarioNormal"));
                p.crearComentario(c);
                
                System.out.println("En la publicacion "+post.getId()+" se comento: ");
                p.getPostComunById(Long.valueOf(id)).getComentarios().forEach(s -> System.out.println(s.getContenido()));
                } catch (Exception ex) {           
            }
        
        
        if(jsonBody.get("borrar")!=null)
            //se borra post
            if(jsonBody.get("borrar").getAsString().compareToIgnoreCase("post")==0)
            try {
                var id = jsonBody.get("id").getAsString();
                System.out.println("Se borrara : "+p.getPostComunById(Long.valueOf(id)).getTitulo());
                p.eliminarPost(Long.valueOf(id));
                if(p.getPostComunById(Long.valueOf(id)).getTitulo()==null)
                    System.out.println("publicacion borrada");
            } catch (Exception ex) {           }
        
        if(jsonBody.get("idPost")!=null)
            try{
                var comentarios=new HashMap<String, HashMap>();
                var i = 0;
                for (var coms : p.getPostComunById(jsonBody.get("idPost").getAsLong()).getComentarios()) {
                    var t = new HashMap<String, String>(); 
                    t.put("id", coms.getId()+"");
                    t.put("contenido", coms.getContenido());
                    t.put("postId", coms.getComun().getId()+"");
                    t.put("normal", coms.getNormal().getNombreCompleto());
                    t.put("fecha", coms.getFechaHora().getTime()+"");
                    
                    comentarios.put("c"+i, t);
                    i++;
                }
                comentarios.forEach((key, value) -> {System.out.println(key + " : " + value + " ");});
                System.out.println("comentarios json : "+new Gson().toJson(comentarios));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(new Gson().toJson(comentarios));
                response.getWriter().flush();
                System.out.println("Se envio comentarios en JSON");
            }catch(Exception ex){            }
        else
            enviarRespuestaJson(request, response);
    }
    
    public void enviarRespuestaJson(HttpServletRequest request, HttpServletResponse response){
        Persistencia p = new FachadaPersistencia();
        var postsComun=new HashMap<String, HashMap>();
        try {
            var i = 0;
            for (var s :p.getAllComunPosts()){
                var t = new HashMap<String, String>(); 
                t.put("id", s.getId()+"");
                t.put("nombre", s.getUsuario().getNombreCompleto());
                t.put("titulo", s.getTitulo());
                t.put("conteindo", s.getContenido());
                
                postsComun.put(""+i, t);
                i++;
            }
            postsComun.forEach((key, value) -> {System.out.println(key + " : " + value + " ");});
            System.out.println("json : "+new Gson().toJson(postsComun));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new Gson().toJson(postsComun));
            response.getWriter().flush();
            System.out.println("Se envio respuesta en JSON");
        } catch (Exception ex) {System.out.println("algo malo paso"); 
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
