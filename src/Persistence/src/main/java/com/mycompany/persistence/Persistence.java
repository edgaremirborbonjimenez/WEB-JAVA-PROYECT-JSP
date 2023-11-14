/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.persistence;

import db.DataBaseConnection;
import domain.Comentario;
import domain.Comun;
import domain.Estado;
import domain.Municipio;
import domain.Normal;
import domain.User;
import domain.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author edemb
 */
public class Persistence {

    public static void main(String[] args) {
        EntityManager entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
//        entityManager.persist(new User("Emir"));

        Estado estado = new Estado("Sonora");

//        entityManager.persist(estado);
        Municipio municipio = new Municipio();
        municipio.setEstado(estado);
        municipio.setNombre("Navojoa");

//        entityManager.persist(municipio);
        Usuario usuario = new Usuario();
        usuario.setAvatar("avatar.png");
        usuario.setCiudad("Navojoa");
        usuario.setContraseña("abcde12345");
        usuario.setCorreo("edemboji@gmail.com");
        usuario.setFechaNacimiento(new Date());
        usuario.setGenero("Masculino");
        usuario.setMunicipio(municipio);
        usuario.setNombreCompleto("Edgar Emir Borbon Jimenez");
        usuario.setTelefono("6421068905");

//        entityManager.persist(usuario);
        Query query = entityManager.createQuery("Select u from Usuario u where u.id= :id").setParameter("id", 2L);
        Usuario u = (Usuario) query.getSingleResult();

        Comun comun = new Comun();
        comun.setUsuario(u);
        comun.setContenido("Hola esta e smi nueva publicacion");
        comun.setFechaHoraCreacon(new Date());
        comun.setTitulo("Hola mundo");

//        entityManager.persist(comun);
//        Query query1 = entityManager.createQuery("Select u from Municipio u where u.id= :id").setParameter("id", 2L);
//        Municipio m = (Municipio) query1.getSingleResult();
//
//        Normal normal = new Normal();
//        normal.setAvatar("perrito.pn");
//        normal.setCiudad("Obregon");
//        normal.setContraseña("abcde12345");
//        normal.setCorreo("juanperez@gmail.com");
//        normal.setFechaNacimiento(new Date());
//        normal.setGenero("Masculino");
//        normal.setMunicipio(m);
//        normal.setNombreCompleto("Juan Perez");
//        normal.setTelefono("6441068432");
//
//        entityManager.persist(normal);

        Query query3 = entityManager.createQuery("Select u from Comun u where u.id= :id").setParameter("id", 1L);
        Comun c = (Comun) query3.getSingleResult();
//
        Query query4 = entityManager.createQuery("Select u from Normal u where u.id= :id").setParameter("id", 3L);
        Normal n = (Normal) query4.getSingleResult();
//
//        Comentario comentario = new Comentario();
//        comentario.setComun(c);
//        comentario.setContenido("Hola mucho gusto");
//        comentario.setFechaHora(new Date());
//        comentario.setNormal(n);
//
//        entityManager.persist(comentario);


        Query query5 = entityManager.createQuery("Select u from Comentario u where u.id= :id").setParameter("id", 1L);
        Comentario coment = (Comentario) query5.getSingleResult();
        
        Comentario replied = new Comentario();
        replied.setComentReplied(coment);
        replied.setComun(c);
        replied.setContenido("Mucho gusto conocerte, respondí a tu comentario");
        replied.setFechaHora(new Date());
        replied.setNormal(n);
        
        entityManager.persist(replied);

        entityManager.getTransaction().commit();
    }
}
