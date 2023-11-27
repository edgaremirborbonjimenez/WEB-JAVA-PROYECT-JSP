package testing;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import dao.interfaces.Persistencia;
import domain.Comentario;
import domain.Comun;
import domain.Estado;
import domain.Municipio;
import domain.Normal;
import domain.Post;
import domain.Usuario;
import fachada.FachadaPersistencia;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author edemb
 */
public class Testing {

    Persistencia fachadaPersistenia = new FachadaPersistencia();

    @Test
    public void registrarUsuarioTest() {
        Usuario usuer = null;
        try {
            Municipio municipios
                    = fachadaPersistenia.registrarMunicipio(
                            new Municipio("Puebla",
                                    new Estado("Nacho")));

            usuer
                    = fachadaPersistenia.registrarUsuario(
                            new Usuario(
                                    "Ramon",
                                    "oman@gmail.com",
                                    "1234",
                                    "1234556778",
                                    "Perro",
                                    "Navojoa",
                                    new Date(),
                                    "Hombre",
                                    municipios));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(usuer);
    }

    @Test
    public void crearPublicacionComunTest() {
        Post post = null;
        Usuario user = null;
        try {
            user = fachadaPersistenia.consultarUsuario("ramon@gmail.com", "1234");
            Comun comun = new Comun();
            comun.setUsuario(user);
            comun.setContenido("Los quiero como test");
            comun.setFechaHoraCreacon(new Date());
            comun.setTitulo("Prueba post");
            post = fachadaPersistenia.crearPost(comun);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertNotNull(post);
    }

    @Test
    public void editarPublicacionComunTest() {
        Comun post = null;

        try {
            post = (Comun) fachadaPersistenia.editarPost(
                    9L,
                    "Post editado",
                    "Edite el post");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(post);
    }

    @Test
    public void crearComentarioTest() {
        Comentario comentario = null;
        Normal user = null;
        Comun post = null;
        try {
            user = (Normal) fachadaPersistenia.consultarUsuario("juanperez@gmail.com", "1234");
            post = (Comun) fachadaPersistenia.getPostById(2L);
            Comentario c = new Comentario();
            c.setNormal(user);
            c.setFechaHora(new Date());
            c.setContenido("Un nuevo comentario");
            c.setComun(post);

            comentario = fachadaPersistenia.crearComentario(c);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(comentario);
    }

    @Test
    public void consultarUsuario() {

        Usuario usuario = null;

        try {
            usuario = fachadaPersistenia.consultarUsuario("ramon@gmail.com", "1234");
        } catch (Exception e) {
            System.out.println("!!Error: " + e.getMessage());
        }

        assertNotNull(usuario);

    }

    @Test
    public void registrarUsuarioConCorreoOcupadoTest() {
        Usuario usuer = null;
        try {
            Municipio municipios
                    = fachadaPersistenia.registrarMunicipio(
                            new Municipio("Puebla",
                                    new Estado("Nacho")));

            usuer
                    = fachadaPersistenia.registrarUsuario(
                            new Usuario(
                                    "Antonio",
                                    "ramon@gmail.com",
                                    "1234",
                                    "1234556778",
                                    "Perro",
                                    "Navojoa",
                                    new Date(),
                                    "Hombre",
                                    municipios));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNull(usuer);
    }

    @Test
    public void getAllPostsTest() {

        List<Post> posts = null;
        try {

            posts = fachadaPersistenia.getAllPosts();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        assertNotNull(posts);
    }

    @Test
    public void registrarEstado() {
        Estado estado = null;
        try {
            estado = fachadaPersistenia.registrarEstado(new Estado("San Luis sinsin"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(estado);
    }

    @Test
    public void eliminarPublicacion() {
        Post post = null;
        try {
            post = fachadaPersistenia.eliminarPost(4L);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertNotNull(post);
    }

    @Test
    public void eliminarComentario() {
        Comentario comentario = null;
        try {
            comentario = fachadaPersistenia.eliminarComentario(1L);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertNotNull(comentario);
    }

    @Test
    public void registrarUsuarioNormalTest() {
        Normal usuer = null;
        try {
            
            Normal u = new Normal();
            u.setNombreCompleto("Juan Perez");
            u.setCorreo("juanperez@gmail.com");
            u.setContraseña("1234");
            u.setTelefono("123456789");
            u.setAvatar("Perro");
            u.setCiudad("Navojoa");
            u.setFechaNacimiento(new Date());
            u.setGenero("Masculino");
            u.setMunicipio(new Municipio("Navojoa", new Estado("Sonora")));
            
            usuer = fachadaPersistenia.registrarUsuarioNormal(u);
            System.out.println(usuer.getId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(usuer);
    }

}
