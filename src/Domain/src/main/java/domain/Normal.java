/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;
import java.util.List;


public class Normal extends Usuario {
    
    List<Comentario> comentarios;

    public Normal() {
    }

    public Normal(List<Comentario> comentarios, Long id, String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Municipio municipio, List<Comun> comun) {
        super(id, nombreCompleto, correo, contraseña, telefono, avatar, ciudad, fechaNacimiento, genero, municipio, comun);
        this.comentarios = comentarios;
    }

    public Normal(List<Comentario> comentarios, String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero,Municipio municipio) {
        super(nombreCompleto, correo, contraseña, telefono, avatar, ciudad, fechaNacimiento, genero,municipio);
        this.comentarios = comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
