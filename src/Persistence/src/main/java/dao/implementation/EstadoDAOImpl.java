package dao.implementation;

import dao.interfaces.EstadoDAO;
import db.DataBaseConnection;
import domain.Estado;
import javax.persistence.EntityManager;

public class EstadoDAOImpl implements EstadoDAO {

    EntityManager entityManager;
    static EstadoDAOImpl estadoDAOImpl;

    private EstadoDAOImpl() {
        this.entityManager = DataBaseConnection.createConnection("webProject");
    }
    
    public static EstadoDAOImpl getInstanceEstadoDAOImpl(){
        if (estadoDAOImpl==null) {
            estadoDAOImpl = new EstadoDAOImpl();
        }
        return estadoDAOImpl;
    }

    @Override
    public Estado registrarEstado(Estado estado) {

        entityManager.getTransaction().begin();

        entityManager.persist(estado);

        entityManager.getTransaction().commit();

        return estado;
    }

}
