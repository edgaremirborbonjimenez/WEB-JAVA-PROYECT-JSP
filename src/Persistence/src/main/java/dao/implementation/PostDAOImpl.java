package dao.implementation;

import dao.interfaces.PostDAO;
import db.DataBaseConnection;
import domain.Post;
import javax.persistence.EntityManager;

public class PostDAOImpl implements PostDAO {

    EntityManager entityManager;
    static PostDAOImpl postDAOImpl;

    private PostDAOImpl() {
        this.entityManager = DataBaseConnection.createConnection("webProject");
    }

    public static PostDAOImpl getInstancePostDAOImpl() {

        if (postDAOImpl == null) {
            postDAOImpl = new PostDAOImpl();
        }
        return postDAOImpl;
    }

    @Override
    public Post crearPost(Post post) {

        entityManager.getTransaction().begin();

        entityManager.persist(post);

        entityManager.getTransaction().commit();

        return post;
    }

    @Override
    public Post eliminarPost(Long id) {

        entityManager.getTransaction().begin();

        Post postEliminado = entityManager.find(Post.class, id);

        if (postEliminado != null) {
            entityManager.remove(postEliminado);
        }
        entityManager.getTransaction().commit();

        return postEliminado;

    }

    @Override
    public Post editarPost(Long id, String titulo, String contenido) {

        entityManager.getTransaction().begin();

        Post postEditado = entityManager.find(Post.class, id);

        if (postEditado != null) {
            postEditado.setTitulo(titulo);
            postEditado.setContenido(contenido);
            entityManager.merge(postEditado);
        }

        entityManager.getTransaction().commit();

        return postEditado;
    }

}
