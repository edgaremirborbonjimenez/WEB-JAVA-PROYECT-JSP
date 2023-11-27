package dao.interfaces;

import domain.Normal;
import domain.Usuario;

public interface UsuarioDAO {

    public Usuario registrarUsuario(Usuario usuario);

    public Normal registrarUsuarioNormal(Normal usuario);

    public Usuario consultarUsuario(String correo, String contrasenia);

    public Usuario conusltarUsuarioByCorreo(String correo);
}
