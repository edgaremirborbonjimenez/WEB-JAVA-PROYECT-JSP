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
    Usuario registrarUsuario(Usuario usuario)throws Exception;
    Usuario consultarUsuario(String correo, String contrasenia)throws Exception;
    Post crearPost(Post post)throws Exception;
    Post eliminarPost(Long id)throws Exception;
    Post editarPost(Long id, String titulo, String contenido)throws Exception;
    Municipio registrarMunicipio(Municipio municipio)throws Exception;
    Estado registrarEstado(Estado estado)throws Exception;
    Comentario crearComentario(Comentario comentario)throws Exception;
    Comentario eliminarComentario(Long id)throws Exception;
}