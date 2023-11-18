/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JIVB
 */
@Entity
@Table(name = "municipios")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "estadoID", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "municipio")
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
