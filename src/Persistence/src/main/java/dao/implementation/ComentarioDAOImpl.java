package dao.implementation;

import dao.interfaces.ComentarioDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;
import domain.Comentario;

public class ComentarioDAOImpl implements ComentarioDAO {

    EntityManager entityManager;
    static ComentarioDAOImpl comentarioDAOImpl;

    private ComentarioDAOImpl() {
        this.entityManager = DataBaseConnection.createConnection("webProject");
    }

    public static ComentarioDAOImpl getInstanceComentarioDAOImpl() {

        if (comentarioDAOImpl == null) {
            comentarioDAOImpl = new ComentarioDAOImpl();
        }
        return comentarioDAOImpl;

    }

    @Override
    public Comentario crearComentario(Comentario comentario) {

        entityManager.getTransaction().begin();

        entityManager.persist(comentario);

        entityManager.getTransaction().commit();

        return comentario;
    }

    @Override
    public Comentario eliminarComentario(Long id) {

        entityManager.getTransaction().begin();

        Comentario comentarioEliminado = entityManager.find(Comentario.class, id);

        if (comentarioEliminado != null) {
            entityManager.remove(comentarioEliminado);
        }
        entityManager.getTransaction().commit();

        return comentarioEliminado;
    }

}
