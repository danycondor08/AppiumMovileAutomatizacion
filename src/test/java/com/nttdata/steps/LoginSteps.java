package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;

public class LoginSteps {

    LoginScreen loginScreen = new LoginScreen();

    public void iniciarSesion(String user, String password) {
        loginScreen.ingresarCredenciales(user, password);
        loginScreen.hacerClicEnLogin();
    }

    // <-- NUEVOS MÉTODOS INTERMEDIARIOS -->
    public void escribirUsuario(String usuario) {
        loginScreen.escribirUsuario(usuario);
    }

    public void hacerClicLogin() {
        loginScreen.hacerClicEnLogin();
    }

    public String obtenerErrorPassword() {
        return loginScreen.obtenerMensajeErrorPassword();
    }
}