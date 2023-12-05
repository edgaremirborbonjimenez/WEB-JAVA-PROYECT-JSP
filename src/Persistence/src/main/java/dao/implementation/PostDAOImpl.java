package dao.implementation;

import dao.interfaces.PostDAO;
import db.DataBaseConnection;
import domain.Anclado;
import domain.Comun;
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
    public Comun crearPostComun(Comun post) {

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
    public Comun getPostComunById(Long id) {

        entityManager.getTransaction().begin();

        Comun post = entityManager.find(Comun.class, id);

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

    @Override
    public Anclado crearPostAnclado(Anclado anclado) {

        entityManager.getTransaction().begin();

        entityManager.persist(anclado);

        entityManager.getTransaction().commit();

        return anclado;

    }

    @Override
    public List<Anclado> getAllAncladoPosts() {
        try {
            String query = "SELECT p FROM Anclado p";
            TypedQuery<Anclado> consulta = entityManager.createQuery(query, Anclado.class);

            List<Anclado> posts = consulta.getResultList();
            return posts;
        } catch (Exception e) {
            return null;
        }    }

    @Override
    public List<Comun> getAllComunPosts() {
        try {
            String query = "SELECT p FROM Comun p";
            TypedQuery<Comun> consulta = entityManager.createQuery(query, Comun.class);

            List<Comun> posts = consulta.getResultList();
            return posts;
        } catch (Exception e) {
            return null;
        }    }

}
