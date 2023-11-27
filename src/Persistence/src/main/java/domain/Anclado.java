/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JIVB
 */
@Entity
@Table(name = "anclados")
public class Anclado extends Post implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "admorID", nullable = false)
    private Admor admor;

    public Anclado() {
    }

    public Anclado(Admor admor, Long id, Date fechaHoraCreacon, Date fechaHoraEdicion, String titulo, String contenido) {
        super(id, fechaHoraCreacon, fechaHoraEdicion, titulo, contenido);
        this.admor = admor;
    }

    public Anclado(Admor admor, Date fechaHoraCreacon, Date fechaHoraEdicion, String titulo, String contenido) {
        super(fechaHoraCreacon, fechaHoraEdicion, titulo, contenido);
        this.admor = admor;
    }

    public Admor getAdmor() {
        return admor;
    }

    public void setAdmor(Admor admor) {
        this.admor = admor;
    }

}
