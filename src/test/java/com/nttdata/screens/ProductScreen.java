package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductScreen {

    public void validarGaleriaCargada() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Products']")
        ));
    }

    public void seleccionarProducto(String productName) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // 1. Intentar hacer clic directamente si ya está visible en la vista actual
            WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId(productName)
            ));
            producto.click();
        } catch (Exception e) {
            try {
                // 2. Si no es visible, hacer scroll vertical buscando por descripción exacta
                WebElement productoScroll = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollIntoView(new UiSelector().description(\"" + productName + "\"));"
                ));
                productoScroll.click();
            } catch (Exception ex) {
                // 3. Fallback dinámico usando descripción parcial basada en el productName recibido
                WebElement productoFallback = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollIntoView(new UiSelector().descriptionContains(\"" + productName + "\"));"
                ));
                productoFallback.click();
            }
        }
    }

    public void indicarCantidad(int cantidadDeseada) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Esperar a que cargue la pantalla de detalles asegurando la visibilidad del producto
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/productIV")
        ));

        // 2. Hacer scroll vertical para asegurar que los botones de cantidad y el contador sean visibles
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                            ".scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/plusIV\"));"
            ));
        } catch (Exception e) {
            // Ignorar si ya está visible
        }

        // 3. Obtener los botones de incremento y decremento
        WebElement btnPlus = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/plusIV")
        ));

        WebElement btnMinus = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/minusIV")
        ));

        // 4. Bucle controlado con pausas de sincronización estrictas para evitar sobreclics
        for (int intento = 0; intento < 15; intento++) {
            try {
                WebElement txtCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("com.saucelabs.mydemoapp.android:id/noTV")
                ));

                String textoValor = txtCantidad.getText();
                if (textoValor != null && !textoValor.trim().isEmpty()) {
                    int cantidadActual = Integer.parseInt(textoValor.trim());

                    if (cantidadActual > cantidadDeseada) {
                        btnMinus.click();
                        // Pausa generosa y obligatoria para que Android procese el evento gráfico del botón menos
                        Thread.sleep(800);
                    } else if (cantidadActual < cantidadDeseada) {
                        btnPlus.click();
                        // Pausa generosa y obligatoria para que Android procese el evento gráfico del botón más
                        Thread.sleep(800);
                    } else {
                        break; // ¡Llegó exactamente al valor deseado y se detiene de inmediato!
                    }
                }
            } catch (Exception e) {
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
    }

    public void hacerClicAddToCart() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement btnAddToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/cartBt")
        ));
        btnAddToCart.click();
    }

    public void validarCarrito() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/cartIV")
        ));
    }

    public void volverAGaleria() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        if (driver != null) {
            driver.navigate().back();
        }
    }

    public void abrirMenuYIrACatalogo() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btnMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/menuIV")
        ));
        btnMenu.click();

        WebElement opcionCatalog = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Catalog\")")
        ));
        opcionCatalog.click();
    }

    public void hacerClicEnCarrito() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btnCarrito = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/cartTV")
        ));
        btnCarrito.click();
    }
}