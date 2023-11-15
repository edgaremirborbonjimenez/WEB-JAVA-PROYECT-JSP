
package dao.implementation;

import dao.interfaces.MunicipioDAO;
import javax.persistence.EntityManager;


public class Municipio implements MunicipioDAO {

    EntityManager entityManager;

    public Municipio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public domain.Municipio registrarMunicipio(domain.Municipio municipio) {
       return null;
    }
    
}
