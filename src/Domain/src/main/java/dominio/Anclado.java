/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;


public class Anclado extends Post {
    
     private Admor admor;

    public Anclado() {
    }

    public Anclado(Admor admor, Long id, Date fechaHoraCreacion ,Date fechaHoraEdicion, String titulo, String contenido) {
        super(id, fechaHoraCreacion, fechaHoraEdicion, titulo, contenido);
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
