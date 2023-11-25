/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;
import java.util.List;


public class Comun extends Post {
    
    private Usuario usuario;

    List<Comentario> comentarios;

    public Comun() {
    }

    public Comun(Usuario usuario, List<Comentario> comentarios, Long id, Date fechaHoraCreacon, Date fechaHoraEdicion, String titulo, String contenido) {
        super(id, fechaHoraCreacon, fechaHoraEdicion, titulo, contenido);
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Comun(Usuario usuario, List<Comentario> comentarios, Date fechaHoraCreacon, Date fechaHoraEdicion, String titulo, String contenido) {
        super(fechaHoraCreacon, fechaHoraEdicion, titulo, contenido);
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
