package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginInvalidoStepsDefs {

    LoginSteps loginSteps = new LoginSteps();

    @When("escribo el usuario {string}")
    public void escribo_el_usuario(String usuario) {
        loginSteps.escribirUsuario(usuario);
    }

    @When("hago clic en el boton Login del modulo de autenticacion")
    public void hago_clic_en_el_boton_login_del_modulo_de_autenticacion() {
        loginSteps.hacerClicLogin();
    }

    @Then("valido que aparezca el mensaje de error de contraseña {string}")
    public void valido_que_aparezca_el_mensaje_de_error_de_contrasena(String mensajeEsperado) {
        String mensajeActual = loginSteps.obtenerErrorPassword();
        Assert.assertEquals("El mensaje de error no coincide", mensajeEsperado, mensajeActual);
    }
}