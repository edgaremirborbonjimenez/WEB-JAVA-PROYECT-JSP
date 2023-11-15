package dao.implementation;

import dao.interfaces.MunicipioDAO;
import db.DataBaseConnection;
import domain.Municipio;
import javax.persistence.EntityManager;

public class MunicipioDAOImpl implements MunicipioDAO {

    EntityManager entityManager;
    static MunicipioDAOImpl municipioDAOImpl;

    private MunicipioDAOImpl() {
        this.entityManager = DataBaseConnection.createConnection("webProject");
    }
    
    public static MunicipioDAOImpl getInstanceMunicipioDAOImpl(){
        if (municipioDAOImpl==null) {
            municipioDAOImpl = new MunicipioDAOImpl();
        }
        return municipioDAOImpl;
    }

    @Override
    public Municipio registrarMunicipio(Municipio municipio) {

        entityManager.getTransaction().begin();

        entityManager.persist(municipio);

        entityManager.getTransaction().commit();

        return municipio;
    }

}
