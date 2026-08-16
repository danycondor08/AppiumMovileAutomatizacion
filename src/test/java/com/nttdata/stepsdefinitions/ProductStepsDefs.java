package com.nttdata.stepsdefinitions;

import com.nttdata.screens.AppConfigScreen;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepsDefs {

    AppConfigScreen appConfigScreen = new AppConfigScreen();
    ProductSteps productSteps = new ProductSteps();

    @Given("ingreso al aplicativo de AppConfig")
    public void ingreso_al_aplicativo_de_app_config() {
        appConfigScreen.iniciarAplicacion();
    }

    @When("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        productSteps.validarGaleria();
    }

    @When("selecciono el producto {string}")
    public void selecciono_el_producto(String productName) {
        productSteps.seleccionarProducto(productName);
    }

    @When("indico la cantidad de {int} unidades")
    public void indico_la_cantidad_de_unidades(int cantidad) {
        productSteps.indicarCantidad(cantidad);
    }

    @When("hago clic en el boton Add to cart")
    public void hago_clic_en_el_boton_add_to_cart() {
        productSteps.hacerClicAddToCart();
    }

    @Then("valido que el carrito de compras refleje el producto y la cantidad correcta")
    public void valido_que_el_carrito_de_compras_refleje_el_producto_y_la_cantidad_correcta() {
        productSteps.validarCarrito();
    }

    @And("vuelvo a la galeria de productos")
    public void vuelvo_a_la_galeria_de_productos() {
        productSteps.volverAGaleria();
    }
}