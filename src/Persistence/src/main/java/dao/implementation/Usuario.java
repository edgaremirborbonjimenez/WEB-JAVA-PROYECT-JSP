
package dao.implementation;

import dao.interfaces.UsuarioDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class Usuario implements UsuarioDAO {

    @Override
    public domain.Usuario registrarUsuario(domain.Usuario usuario) {
        
        EntityManager entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
        
        entityManager.persist(usuario);
        
        entityManager.getTransaction().commit();
        
        return usuario;
    }

    @Override
    public domain.Usuario consultarUsuario(String correo, String contrasenia) {
          EntityManager entityManager = DataBaseConnection.createConnection("webProject");

            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";
            TypedQuery<domain.Usuario> consulta = entityManager.createQuery(jpql, domain.Usuario.class);
            consulta.setParameter("correo", correo);
            consulta.setParameter("contrasenia", contrasenia);

            domain.Usuario usuario = consulta.getSingleResult();
            
            return usuario;
    }
    
}
