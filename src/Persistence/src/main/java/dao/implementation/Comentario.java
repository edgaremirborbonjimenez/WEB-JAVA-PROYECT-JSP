
package dao.implementation;

import dao.interfaces.ComentarioDAO;
import javax.persistence.EntityManager;

public class Comentario implements ComentarioDAO {
    
    EntityManager entityManager;

    public Comentario(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public domain.Comentario crearComentario(domain.Comentario comentario) {
       return null;
    }

    @Override
    public domain.Comentario eliminarComentario(Long id) {
        return null;
    }
    
}
