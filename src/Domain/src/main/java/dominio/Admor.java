/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import java.util.List;


public class Admor extends Usuario {
    
      private List<Anclado> anclado;

    public Admor() {
    }

    public Admor(List<Anclado> anclado, Long id, String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Municipio municipio, List<Comun> comun) {
        super(id, nombreCompleto, correo, contraseña, telefono, avatar, ciudad, fechaNacimiento, genero, municipio, comun);
        this.anclado = anclado;
    }

    public Admor(List<Anclado> anclado, String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero,Municipio municipio) {
        super(nombreCompleto, correo, contraseña, telefono, avatar, ciudad, fechaNacimiento, genero,municipio);
        this.anclado = anclado;
    }

    public List<Anclado> getAnclado() {
        return anclado;
    }

    public void setAnclado(List<Anclado> anclado) {
        this.anclado = anclado;
    }
}
