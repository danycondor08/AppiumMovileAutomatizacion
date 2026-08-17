package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.en.And;

public class CartStepsDefs {

    CartSteps cartSteps = new CartSteps();

    @And("hago clic en el boton Proceed To Checkout")
    public void hago_clic_en_el_boton_proceed_to_checkout() {
        cartSteps.hacerClicProceedToCheckout();
    }
}