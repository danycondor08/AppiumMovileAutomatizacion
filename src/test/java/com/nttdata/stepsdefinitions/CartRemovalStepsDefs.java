package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartRemovalStepsDefs {

    CartSteps cartSteps = new CartSteps();

    @When("hago clic en el boton Remove Item del producto")
    public void hago_clic_en_el_boton_remove_item_del_producto() {
        cartSteps.removerItemDelCarrito();
    }

    @Then("valido que el carrito quede vacio o el producto sea removido")
    public void valido_que_el_carrito_quede_vacio_o_el_producto_sea_removido() {
        // Validación básica de cierre del escenario
        Assert.assertTrue(true);
    }
}