package com.nttdata.steps;

import com.nttdata.screens.CartScreen;

public class CartSteps {

    CartScreen cartScreen = new CartScreen();

    public void hacerClicProceedToCheckout() {
        cartScreen.hacerClicProceedToCheckout();
    }

    // <-- NUEVO MÉTODO INTERMEDIARIO -->
    public void removerItemDelCarrito() {
        cartScreen.hacerClicEnRemoverItem();
    }
}