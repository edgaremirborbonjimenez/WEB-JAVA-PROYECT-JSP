
package dao.implementation;

import dao.interfaces.PostDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;


public class Post implements PostDAO {

    EntityManager entityManager;

    public Post(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public domain.Post crearPost(domain.Post post) {
        
        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();

        entityManager.persist(post);

        entityManager.getTransaction().commit();

        return post;
    }

    @Override
    public domain.Post eliminarPost(Long id) {
     
        domain.Post postEliminado = null;

        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();

        postEliminado = entityManager.find(domain.Post.class, id);
        
        if (postEliminado != null) {
                entityManager.remove(postEliminado);
            }
        entityManager.getTransaction().commit();
        
        return postEliminado;

    }

    @Override
    public domain.Post editarPost(Long id, String titulo, String contenido) {

        domain.Post postEditado = null;

        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();

        postEditado = entityManager.find(domain.Post.class, id);

        if (postEditado != null) {
            postEditado.setTitulo(titulo);
            postEditado.setContenido(contenido);
            entityManager.merge(postEditado);
        }

        entityManager.getTransaction().commit();

        return postEditado;
    }
    
}
