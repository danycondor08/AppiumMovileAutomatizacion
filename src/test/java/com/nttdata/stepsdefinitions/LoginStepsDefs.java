package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;

public class LoginStepsDefs {

    LoginSteps loginSteps = new LoginSteps();

    @And("ingreso las credenciales de usuario {string} y contraseña {string}")
    public void ingreso_las_credenciales_de_usuario_y_contrasena(String user, String password) {
        loginSteps.iniciarSesion(user, password);
    }
}