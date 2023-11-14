/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 *
 * @author JIVB
 */
@Entity
public class Anclado extends Post implements Serializable {
    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Admor admor;
}
