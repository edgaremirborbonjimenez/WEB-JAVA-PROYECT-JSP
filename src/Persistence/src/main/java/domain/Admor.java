/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author JIVB
 */
@Entity
public class Admor extends Usuario implements Serializable {
    @OneToMany(mappedBy = "admor")
    private List<Anclado> anclado;
}
