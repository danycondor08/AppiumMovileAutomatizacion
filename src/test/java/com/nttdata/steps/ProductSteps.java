package com.nttdata.steps;

import com.nttdata.screens.ProductScreen;
import java.util.List;
import java.util.Map;

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

    public void volverAlCatalogoDesdeMenu() {
        productScreen.abrirMenuYIrACatalogo();
    }

    public void hacerClicEnElCarrito() {
        productScreen.hacerClicEnCarrito();
    }

    // Nuevo método integrado
    public void agregarProductosDesdeTabla(List<Map<String, String>> productos) {
        for (Map<String, String> fila : productos) {
            String nombreProducto = fila.get("producto");
            int cantidad = Integer.parseInt(fila.get("cantidad"));

            seleccionarProducto(nombreProducto);
            indicarCantidad(cantidad);
            hacerClicAddToCart();
            volverAlCatalogoDesdeMenu();
        }
    }
}