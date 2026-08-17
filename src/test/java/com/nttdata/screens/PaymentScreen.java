package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentScreen {

    public void completarMetodoDePago(String fullName, String cardNumber, String expirationDate, String securityCode) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.saucelabs.mydemoapp.android:id/nameET"))).clear();
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/nameET")).sendKeys(fullName);

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cardNumberET")).clear();
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cardNumberET")).sendKeys(cardNumber);

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/expirationDateET")).clear();
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/expirationDateET")).sendKeys(expirationDate);

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/securityCodeET")).clear();
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/securityCodeET")).sendKeys(securityCode);
    }

    public void hacerClicEnReviewOrder() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btnReviewOrder = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")
        ));
        btnReviewOrder.click();
    }

    public void hacerClicEnPlaceOrder() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btnPlaceOrder = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")
        ));
        btnPlaceOrder.click();
    }
}