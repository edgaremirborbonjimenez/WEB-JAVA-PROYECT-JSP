/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JIVB
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.DATE)
    private Date fechaHora;

    @Column(name = "contenido")
    private String contenido;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "comunID", nullable = false)
    private Comun comun;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "normalID", nullable = false)
    private Normal normal;

    @ManyToOne()
    @JoinColumn(name = "comentarioID", nullable = true)
    private Comentario comentReplied;

    @OneToMany(mappedBy = "comentReplied")
    private List<Comentario> comentsResponse;

    public Comentario() {
    }

    public Comentario(Long id, Date fechaHora, String contenido, Comun comun, Normal normal) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comun = comun;
        this.normal = normal;
    }

    public Comentario(Date fechaHora, String contenido, Comun comun, Normal normal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comun = comun;
        this.normal = normal;
    }

    public Comentario getComentReplied() {
        return comentReplied;
    }

    public void setComentReplied(Comentario comentReplied) {
        this.comentReplied = comentReplied;
    }

    public List<Comentario> getComentsResponse() {
        return comentsResponse;
    }

    public void setComentsResponse(List<Comentario> comentsResponse) {
        this.comentsResponse = comentsResponse;
    }
    
    

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comun getComun() {
        return comun;
    }

    public void setComun(Comun comun) {
        this.comun = comun;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
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
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Comentario[ id=" + id + " ]";
    }

}
