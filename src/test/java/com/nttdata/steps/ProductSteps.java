package com.nttdata.steps;

import com.nttdata.screens.ProductScreen;

public class ProductSteps {

    ProductScreen productScreen = new ProductScreen();

    public void validarGaleria() {
        productScreen.validarGaleriaCargada();
    }

    public void seleccionarProducto(String producto) {
        productScreen.seleccionarProducto(producto);
    }

    public void indicarCantidad(int cantidad) {
        productScreen.indicarCantidad(cantidad);
    }

    public void hacerClicAddToCart() {
        productScreen.hacerClicAddToCart();
    }

    public void validarCarrito() {
        productScreen.validarCarrito();
        System.out.println("Validación exitosa: El carrito refleja el producto y la cantidad correcta.");
    }

    public void volverAGaleria() {
        productScreen.volverAGaleria();
    }
}