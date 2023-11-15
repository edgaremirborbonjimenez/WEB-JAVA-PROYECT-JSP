
package dao.implementation;

import dao.interfaces.MunicipioDAO;
import db.DataBaseConnection;
import javax.persistence.EntityManager;


public class Municipio implements MunicipioDAO {

    EntityManager entityManager;

    public Municipio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public domain.Municipio registrarMunicipio(domain.Municipio municipio) {
       
        entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
        
        entityManager.persist(municipio);
        
        entityManager.getTransaction().commit();
        
        return municipio;
    }
    
}
