
package dao.implementation;

import dao.interfaces.PostDAO;
import javax.persistence.EntityManager;


public class Post implements PostDAO {

    EntityManager entityManager;

    public Post(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public domain.Post crearPost(domain.Post post) {
       return null;
    }

    @Override
    public domain.Post eliminarPost(Long id) {
       return null; 
    }

    @Override
    public domain.Post editarPost(String titulo, String contenido) {
       return null; 
    }
    
}
