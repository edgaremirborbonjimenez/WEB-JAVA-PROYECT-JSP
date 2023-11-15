
package dao.interfaces;

import domain.Usuario;


public interface UsuarioDAO {
    
    public Usuario registrarUsuario(Usuario usuario);
    
    public Usuario consultarUsuario(String correo, String contrasenia);
}
