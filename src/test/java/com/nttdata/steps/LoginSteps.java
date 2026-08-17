package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;

public class LoginSteps {

    LoginScreen loginScreen = new LoginScreen();

    public void iniciarSesion(String user, String password) {
        loginScreen.ingresarCredenciales(user, password);
        loginScreen.hacerClicEnLogin();
    }
}