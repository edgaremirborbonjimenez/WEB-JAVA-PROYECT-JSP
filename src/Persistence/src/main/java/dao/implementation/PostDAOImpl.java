package dao.implementation;

import dao.interfaces.PostDAO;
import db.DataBaseConnection;
import domain.Post;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
            postEditado.setFechaHoraEdicion(new Date());
            entityManager.merge(postEditado);
        }

        entityManager.getTransaction().commit();

        return postEditado;
    }

    @Override
    public Post getPostById(Long id) {

        entityManager.getTransaction().begin();

        Post post = entityManager.find(Post.class, id);

        entityManager.getTransaction().commit();

        return post;

    }

    @Override
    public List<Post> getAllPosts() {

        try {
            String query = "SELECT p FROM Post p";
            TypedQuery<Post> consulta = entityManager.createQuery(query, Post.class);

            List<Post> posts = consulta.getResultList();
            return posts;
        } catch (Exception e) {
            return null;
        }

    }

}
