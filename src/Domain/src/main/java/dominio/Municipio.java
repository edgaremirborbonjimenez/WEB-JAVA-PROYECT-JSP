/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 *
 * @author Cristian
 */
public class Municipio {
    

    private Long id;
    private String nombre;
    private Estado estado;
    private List<Usuario> usuarios;

    public Municipio() {
    }

    public Municipio(Long id, String nombre, Estado estado, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    public Municipio(String nombre, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
