/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author edemb
 */
public class DataBaseConnection {

    static EntityManager connection;

    private DataBaseConnection() {
    }

    public static EntityManager createConnection(String persistenceUnitName) {
        if (DataBaseConnection.connection == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            DataBaseConnection.connection = emf.createEntityManager();
        }
        return DataBaseConnection.connection;

    }

}