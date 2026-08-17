package com.nttdata.steps;

import com.nttdata.screens.PaymentScreen;

public class PaymentSteps {

    PaymentScreen paymentScreen = new PaymentScreen();

    public void llenarMetodoDePago(String fullName, String cardNumber, String expirationDate, String securityCode) {
        paymentScreen.completarMetodoDePago(fullName, cardNumber, expirationDate, securityCode);
    }

    public void hacerReviewOrder() {
        paymentScreen.hacerClicEnReviewOrder();
    }

    public void hacerPlaceOrder() {
        paymentScreen.hacerClicEnPlaceOrder();
    }
}