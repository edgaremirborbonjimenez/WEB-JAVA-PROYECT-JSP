
package dao.implementation;

import dao.interfaces.ComentarioDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;

public class Comentario implements ComentarioDAO {
    
    EntityManager entityManager;

    public Comentario(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public domain.Comentario crearComentario(domain.Comentario comentario) {
       
        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
        
        entityManager.persist(comentario);
        
        entityManager.getTransaction().commit();
        
        return comentario;
    }

    @Override
    public domain.Comentario eliminarComentario(Long id) {
        
         domain.Comentario comentarioEliminado = null;

        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();

        comentarioEliminado = entityManager.find(domain.Comentario.class, id);
        
        if (comentarioEliminado != null) {
                entityManager.remove(comentarioEliminado);
            }
        entityManager.getTransaction().commit();
        
        return comentarioEliminado;
    }
    
}
