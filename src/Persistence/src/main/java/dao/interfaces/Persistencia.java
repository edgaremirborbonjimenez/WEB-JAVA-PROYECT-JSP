/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import domain.Comentario;
import domain.Estado;
import domain.Municipio;
import domain.Post;
import domain.Usuario;

/**
 *
 * @author edemb
 */
public interface Persistencia {
    Usuario registrarUsuario(Usuario usuario);
    Usuario consultarUsuario(String correo, String contrasenia);
    Post crearPost(Post post);
    Post eliminarPost(Long id);
    Post editarPost(Long id, String titulo, String contenido);
    Municipio registrarMunicipio(Municipio municipio);
    Estado registrarEstado(Estado estado);
    Comentario crearComentario(Comentario comentario);
    Comentario eliminarComentario(Long id);
}
