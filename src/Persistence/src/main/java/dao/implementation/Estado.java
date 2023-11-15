
package dao.implementation;

import dao.interfaces.EstadoDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;


public class Estado implements EstadoDAO {

    EntityManager entityManager;

    public Estado(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public domain.Estado registrarEstado(domain.Estado estado) {
       
        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
        
        entityManager.persist(estado);
        
        entityManager.getTransaction().commit();
        
        return estado;
    }
    
}
