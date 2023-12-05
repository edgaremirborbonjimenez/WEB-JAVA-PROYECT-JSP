/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

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
public interface Persistencia {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Admor registrarUsuarioAdmin(Admor admor) throws Exception;

    Normal registrarUsuarioNormal(Normal usuario) throws Exception;

    Usuario consultarUsuario(String correo, String contrasenia) throws Exception;

    Normal consultarUsuarioNormal(String correo, String contrasenia) throws Exception;

    Admor consultarUsuarioAdmor(String correo, String contrasenia) throws Exception;

    Usuario consultarUsuarioByEmail(String correo) throws Exception;

    Comun crearPostComun(Comun post) throws Exception;

    Anclado crearPostAnclado(Anclado post) throws Exception;

    Post eliminarPost(Long id) throws Exception;

    Post editarPost(Long id, String titulo, String contenido) throws Exception;

    Post getPostById(Long id) throws Exception;

    Municipio registrarMunicipio(Municipio municipio) throws Exception;

    Estado registrarEstado(Estado estado) throws Exception;

    Comentario crearComentario(Comentario comentario) throws Exception;

    Comentario eliminarComentario(Long id) throws Exception;

    List<Post> getAllPosts() throws Exception;

    List<Anclado> getAllAncladoPosts() throws Exception;

    List<Comun> getAllComunPosts() throws Exception;

}
