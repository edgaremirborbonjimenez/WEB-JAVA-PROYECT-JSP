/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author edemb
 */
public abstract class Utils {

    public static boolean isEmailValid(String correo) {
        String patronCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(patronCorreo);

        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }

    public static boolean isNameValid(String nombreCompleto) {
        String patronNombreUsuario = "^[a-zA-Z ]+$";

        Pattern pattern = Pattern.compile(patronNombreUsuario);

        Matcher matcher = pattern.matcher(nombreCompleto);

        return matcher.matches();
    }

    public static boolean isPhonNumberValid(String numeroTelefono) {
        String patronNumeroTelefono = "^[0-9]{10}$";

        Pattern pattern = Pattern.compile(patronNumeroTelefono);

        Matcher matcher = pattern.matcher(numeroTelefono);

        return matcher.matches();
    }
    
        public static boolean isPasswordValid(String contrasena) {
        //al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número
        String patronContrasena = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        Pattern pattern = Pattern.compile(patronContrasena);

        Matcher matcher = pattern.matcher(contrasena);

        return matcher.matches();
    }

}
