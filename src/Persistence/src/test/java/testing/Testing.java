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
            Municipio municipios = fachadaPersistenia.registrarMunicipio(new Municipio("Puebla", new Estado("Nacho")));

            usuer = fachadaPersistenia.registrarUsuario(new Usuario("Antonio", "antonio@gmail.com", "1234", "1234556778", "Perro", "Navojoa", new Date(), "Hombre", municipios));

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
            user = fachadaPersistenia.consultarUsuario("antonio@gmail.com", "1234");
            Comun comun = new Comun();
            comun.setUsuario(user);
            comun.setContenido("Los quiero como test");
            comun.setFechaHoraCreacon(new Date());
            comun.setTitulo("Prueba post");
            post = fachadaPersistenia.crearPost(comun);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertNotNull(post.getId());
    }

    @Test
    public void editarPublicacionComunTest() {
        Comun post = null;

        try {
            post = (Comun) fachadaPersistenia.editarPost(1L, "Post editado", "Edite el post");
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
            user = (Normal) fachadaPersistenia.consultarUsuario("juanperez@gmail.com", "abcde12345");
            post = (Comun) fachadaPersistenia.getPostById(8L);
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

}
