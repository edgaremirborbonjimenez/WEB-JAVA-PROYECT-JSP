/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import java.util.List;


public class Usuario {
    

    private Long id;
    private String nombreCompleto;
    private String correo;
    private String contraseña;
    private String telefono;
    private String avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private String genero;
    private Municipio municipio;

    private List<Comun> comun;
    
    public Usuario() {
    }

    public Usuario(Long id, String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Municipio municipio, List<Comun> comun) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
        this.comun = comun;
    }

    public Usuario(String nombreCompleto, String correo, String contraseña, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero,Municipio municipio) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Comun> getComun() {
        return comun;
    }

    public void setComun(List<Comun> comun) {
        this.comun = comun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
