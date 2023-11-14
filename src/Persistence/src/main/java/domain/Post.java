/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JIVB
 */
//@jakarta.persistence.Entity
@Entity
@Table(name = "post")
public class Post implements Serializable {

    public Post() {
    }

    public Post(Long id, Date fechaHoraCreacon, Date fechaHoraEdicion, String titulo, String contenido) {
        this.id = id;
        this.fechaHoraCreacon = fechaHoraCreacon;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "fechaHoraCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaHoraCreacon;
    
    @Column(name= "fechaHoraEdicion")
    @Temporal(TemporalType.DATE)
    private Date fechaHoraEdicion;
    
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
    
    @Column(name = "contenido", length = 50, nullable = false)
    private String contenido;

    public Date getFechaHoraCreacon() {
        return fechaHoraCreacon;
    }

    public void setFechaHoraCreacon(Date fechaHoraCreacon) {
        this.fechaHoraCreacon = fechaHoraCreacon;
    }

    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Post[ id=" + id + " ]";
    }
    
}
