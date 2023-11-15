/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.factory;

import dao.implementation.ComentarioDAOImpl;
import dao.implementation.EstadoDAOImpl;
import dao.implementation.MunicipioDAOImpl;
import dao.implementation.PostDAOImpl;
import dao.implementation.UsuarioDAOImpl;
import dao.interfaces.ComentarioDAO;
import dao.interfaces.EstadoDAO;
import dao.interfaces.MunicipioDAO;
import dao.interfaces.PostDAO;
import dao.interfaces.UsuarioDAO;

/**
 *
 * @author edemb
 */
public abstract class DAOFactory {

    
    public static ComentarioDAO getComentarioDAO(){
        return ComentarioDAOImpl.getInstanceComentarioDAOImpl();
    }
    
    public static EstadoDAO getEstadoDAO(){
        return EstadoDAOImpl.getInstanceEstadoDAOImpl();
    }
    
    public static MunicipioDAO getMunicipioDAO(){
        return MunicipioDAOImpl.getInstanceMunicipioDAOImpl();
    }
    
    public static PostDAO getPostDAO(){
        return PostDAOImpl.getInstancePostDAOImpl();
    }
    
    public static UsuarioDAO getUsuarioDAO(){
        return UsuarioDAOImpl.getInstanceUsuarioDAOImpl();
    }
    
}
