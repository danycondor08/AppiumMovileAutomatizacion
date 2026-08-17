package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CheckoutSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class CheckoutStepsDefs {

    CheckoutSteps checkoutSteps = new CheckoutSteps();

    @And("completo el formulario de direccion de envio con los siguientes datos:")
    public void completo_el_formulario_de_direccion_de_envio(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            checkoutSteps.llenarDireccionEnvio(
                    row.get("fullName"),
                    row.get("address1"),
                    row.get("address2"),
                    row.get("city"),
                    row.get("state"),
                    row.get("zipCode"),
                    row.get("country")
            );
        }
    }

    @And("hago clic en el boton To Payment")
    public void hago_clic_en_el_boton_to_payment() {
        checkoutSteps.irAPayment();
    }
}