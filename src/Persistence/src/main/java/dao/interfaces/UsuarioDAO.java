package dao.interfaces;

import domain.Admor;
import domain.Normal;
import domain.Usuario;

public interface UsuarioDAO {

    public Usuario registrarUsuario(Usuario usuario);

    public Admor registrarUsuarioAdmin(Admor admin);

    public Normal registrarUsuarioNormal(Normal usuario);

    public Usuario consultarUsuario(String correo, String contrasenia);

    public Normal consultarUsuarioNormal(String correo, String contrasenia);

    public Admor consultarUsuarioAdmor(String correo, String contrasenia);

    public Usuario conusltarUsuarioByCorreo(String correo);
}
