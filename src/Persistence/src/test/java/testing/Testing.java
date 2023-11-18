package testing;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import dao.interfaces.Persistencia;
import domain.Estado;
import domain.Municipio;
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

            usuer = fachadaPersistenia.registrarUsuario(new Usuario("Antonio", "antonio@gmail.com", "1234", "1234556778", "Perro", "Navojoa", new Date(), "Hombre",municipios));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotNull(usuer);
    }

}