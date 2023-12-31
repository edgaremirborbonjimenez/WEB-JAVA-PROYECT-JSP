package dao.implementation;

import dao.interfaces.UsuarioDAO;
import db.DataBaseConnection;
import domain.Admor;
import domain.Normal;
import domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAOImpl implements UsuarioDAO {

    EntityManager entityManager;
    static UsuarioDAOImpl usuarioDAOImpl;

    private UsuarioDAOImpl() {
        this.entityManager = DataBaseConnection.createConnection("webProject");
    }

    public static UsuarioDAOImpl getInstanceUsuarioDAOImpl() {
        if (usuarioDAOImpl == null) {
            usuarioDAOImpl = new UsuarioDAOImpl();
        }
        return usuarioDAOImpl;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {

        Usuario u = this.conusltarUsuarioByCorreo(usuario.getCorreo());

        if (u != null) {
            return null;
        }
        entityManager.getTransaction().begin();

        entityManager.persist(usuario);

        entityManager.getTransaction().commit();

        return usuario;
    }

    @Override
    public Usuario consultarUsuario(String correo, String contrasenia) {
        Usuario usuario = null;
        try {
            String query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contraseña = :contraseña";
            TypedQuery<Usuario> consulta = entityManager.createQuery(query, Usuario.class);
            consulta.setParameter("correo", correo);
            consulta.setParameter("contraseña", contrasenia);

            usuario = consulta.getSingleResult();

            return usuario;
        } catch (Exception e) {
            return usuario;
        }
    }
    
        @Override
    public Normal consultarUsuarioNormal(String correo, String contrasenia) {
        Normal usuario = null;
        try {
            String query = "SELECT u FROM Normal u WHERE u.correo = :correo AND u.contraseña = :contraseña";
            TypedQuery<Normal> consulta = entityManager.createQuery(query, Normal.class);
            consulta.setParameter("correo", correo);
            consulta.setParameter("contraseña", contrasenia);

            usuario = consulta.getSingleResult();

            return usuario;
        } catch (Exception e) {
            return usuario;
        }
    }
    
        @Override
    public Admor consultarUsuarioAdmor(String correo, String contrasenia) {
        Admor usuario = null;
        try {
            String query = "SELECT u FROM Admor u WHERE u.correo = :correo AND u.contraseña = :contraseña";
            TypedQuery<Admor> consulta = entityManager.createQuery(query, Admor.class);
            consulta.setParameter("correo", correo);
            consulta.setParameter("contraseña", contrasenia);

            usuario = consulta.getSingleResult();

            return usuario;
        } catch (Exception e) {
            return usuario;
        }
    }

    @Override
    public Usuario conusltarUsuarioByCorreo(String correo) {
        Usuario usuario = null;
        try {
            String query = "SELECT u FROM Usuario u WHERE u.correo = :correo";
            TypedQuery<Usuario> consulta = entityManager.createQuery(query, Usuario.class);
            consulta.setParameter("correo", correo);

            usuario = consulta.getSingleResult();

            return usuario;
        } catch (Exception e) {
            return usuario;
        }
    }

    @Override
    public Normal registrarUsuarioNormal(Normal usuario) {
        Usuario u = this.conusltarUsuarioByCorreo(usuario.getCorreo());

        if (u != null) {
            return null;
        }
        entityManager.getTransaction().begin();

        entityManager.persist(usuario);

        entityManager.getTransaction().commit();

        return usuario;
    }

    @Override
    public Admor registrarUsuarioAdmin(Admor admin) {

        Usuario u = this.conusltarUsuarioByCorreo(admin.getCorreo());

        if (u != null) {
            return null;
        }
        entityManager.getTransaction().begin();

        entityManager.persist(admin);

        entityManager.getTransaction().commit();

        return admin;

    }

}
