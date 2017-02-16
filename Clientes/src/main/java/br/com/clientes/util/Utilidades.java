package br.com.clientes.util;

public class Utilidades {

    public static boolean isUsuarioValido(String usuario, String senha) {
        String user = "admin";
        String pass = "1234";

        if ((usuario.equals(user)) && (senha.equals(pass))) {
            return true;
        }

        return false;
    }
}
