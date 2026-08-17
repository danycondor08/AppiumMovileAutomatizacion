package com.nttdata.steps;

import com.nttdata.screens.CheckoutScreen;

public class CheckoutSteps {

    CheckoutScreen checkoutScreen = new CheckoutScreen();

    public void llenarDireccionEnvio(String fullName, String address1, String address2, String city, String state, String zipCode, String country) {
        checkoutScreen.completarFormularioEnvio(fullName, address1, address2, city, state, zipCode, country);
    }

    public void irAPayment() {
        checkoutScreen.hacerClicEnToPayment();
    }
}