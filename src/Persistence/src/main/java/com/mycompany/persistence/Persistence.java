/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistence;

import db.DataBaseConnection;
import domain.User;
import javax.persistence.EntityManager;

/**
 *
 * @author edemb
 */
public class Persistence {

    public static void main(String[] args) {
        EntityManager entityManager = DataBaseConnection.createConnection("webProject");
        entityManager.getTransaction().begin();
        entityManager.persist(new User("Emir"));
        entityManager.getTransaction().commit();    }
}
