/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dao.factory.DAOFactory;
import dao.implementation.ComentarioDAOImpl;
import dao.interfaces.ComentarioDAO;
import dao.interfaces.EstadoDAO;
import dao.interfaces.MunicipioDAO;
import dao.interfaces.Persistencia;
import dao.interfaces.PostDAO;
import dao.interfaces.UsuarioDAO;
import domain.Admor;
import domain.Anclado;
import domain.Comentario;
import domain.Comun;
import domain.Estado;
import domain.Municipio;
import domain.Normal;
import domain.Post;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author edemb
 */
public class FachadaPersistencia implements Persistencia {

    ComentarioDAO comentarioDAO;
    EstadoDAO estadoDAO;
    MunicipioDAO municipioDAO;
    PostDAO postDAO;
    UsuarioDAO usuarioDAO;

    public FachadaPersistencia() {
        comentarioDAO = DAOFactory.getComentarioDAO();
        estadoDAO = DAOFactory.getEstadoDAO();
        municipioDAO = DAOFactory.getMunicipioDAO();
        postDAO = DAOFactory.getPostDAO();
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        try {
            return usuarioDAO.registrarUsuario(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(String correo, String contrasenia) throws Exception {
        try {
            return usuarioDAO.consultarUsuario(correo, contrasenia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Usuario consultarUsuarioByEmail(String correo) throws Exception {
        try {
            return usuarioDAO.conusltarUsuarioByCorreo(correo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Comun crearPostComun(Comun post) throws Exception {
        try {
            return postDAO.crearPostComun(post);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Post eliminarPost(Long id) throws Exception {
        try {
            return postDAO.eliminarPost(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Post editarPost(Long id, String titulo, String contenido) throws Exception {
        try {
            return postDAO.editarPost(id, titulo, contenido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Municipio registrarMunicipio(Municipio municipio) throws Exception {
        try {
            return municipioDAO.registrarMunicipio(municipio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Estado registrarEstado(Estado estado) throws Exception {
        try {
            return estadoDAO.registrarEstado(estado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {
        try {
            return comentarioDAO.crearComentario(comentario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Comentario eliminarComentario(Long id) throws Exception {
        try {
            return comentarioDAO.eliminarComentario(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Comun getPostComunById(Long id) throws Exception {

        try {
            return postDAO.getPostComunById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Post> getAllPosts() throws Exception {

        try {
            return postDAO.getAllPosts();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Normal registrarUsuarioNormal(Normal usuario) throws Exception {

        try {
            return usuarioDAO.registrarUsuarioNormal(usuario);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Admor registrarUsuarioAdmin(Admor admor) throws Exception {
        try {
            return usuarioDAO.registrarUsuarioAdmin(admor);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Anclado> getAllAncladoPosts() throws Exception {
        try {
            return postDAO.getAllAncladoPosts();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Comun> getAllComunPosts() throws Exception {
        try {
            return postDAO.getAllComunPosts();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Anclado crearPostAnclado(Anclado post) throws Exception {
        try {

            return postDAO.crearPostAnclado(post);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
