/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.persistencia;

import daos.DataBaseConnection;
import domain.User;
import javax.persistence.EntityManager;

/**
 *
 * @author edemb
 */
public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = DataBaseConnection.createConnection("website");
        entityManager.getTransaction().begin();
        entityManager.persist(new User("Emir"));
        entityManager.getTransaction().commit();
    }
}
