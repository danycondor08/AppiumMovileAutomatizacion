package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutScreen {

    public void completarFormularioEnvio(String fullName, String address1, String address2, String city, String state, String zipCode, String country) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.saucelabs.mydemoapp.android:id/fullNameET"))).sendKeys(fullName);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/address1ET")).sendKeys(address1);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/address2ET")).sendKeys(address2);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cityET")).sendKeys(city);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/stateET")).sendKeys(state);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/zipET")).sendKeys(zipCode);
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/countryET")).sendKeys(country);
    }

    // <-- MÉTODO FALTANTE QUE NECESITAS AGREGAR -->
    public void hacerClicEnToPayment() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btnToPayment = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")
        ));
        btnToPayment.click();
    }
}