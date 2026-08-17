package com.nttdata.stepsdefinitions;

import com.nttdata.steps.PaymentSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class PaymentStepsDefs {

    PaymentSteps paymentSteps = new PaymentSteps();

    @And("completo el formulario de metodo de pago con los siguientes datos:")
    public void completo_el_formulario_de_metodo_de_pago(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            paymentSteps.llenarMetodoDePago(
                    row.get("fullName"),
                    row.get("cardNumber"),
                    row.get("expirationDate"),
                    row.get("securityCode")
            );
        }
    }

    @And("hago clic en el boton Review Order")
    public void hago_clic_en_el_boton_review_order() {
        paymentSteps.hacerReviewOrder();
    }

    @And("hago clic en el boton Place Order")
    public void hago_clic_en_el_boton_place_order() {
        paymentSteps.hacerPlaceOrder();
    }
}