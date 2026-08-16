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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Realiza scroll en la galería principal hasta encontrar el producto
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + productName + "\"))"
        ));

        WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId(productName)
        ));
        producto.click();
    }

    public void indicarCantidad(int cantidadDeseada) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Localizamos el elemento que muestra la cantidad actual en pantalla
        WebElement txtCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/noTV")
        ));

        int cantidadActual = Integer.parseInt(txtCantidad.getText());

        WebElement btnPlus = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/plusIV")
        ));

        WebElement btnMinus = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/minusIV")
        ));

        // Ajusta dinámicamente si la cantidad en pantalla es mayor o menor a la deseada
        while (cantidadActual < cantidadDeseada) {
            btnPlus.click();
            cantidadActual++;
        }
        while (cantidadActual > cantidadDeseada) {
            btnMinus.click();
            cantidadActual--;
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
}