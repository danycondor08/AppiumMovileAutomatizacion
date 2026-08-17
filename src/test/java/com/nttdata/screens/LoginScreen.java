package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginScreen {

    public void ingresarCredenciales(String user, String password) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement txtUsername = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/nameET")
        ));
        txtUsername.clear();
        txtUsername.sendKeys(user);

        WebElement txtPassword = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/passwordET"));
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void hacerClicEnLogin() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/loginBtn")
        ));
        btnLogin.click();
    }

    // <-- NUEVOS MÉTODOS PARA EL FLUJO DE LOGIN INVÁLIDO -->
    public void escribirUsuario(String usuario) {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement txtUsername = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/nameET")
        ));
        txtUsername.clear();
        txtUsername.sendKeys(usuario);
    }

    public String obtenerMensajeErrorPassword() {
        AndroidDriver driver = AppConfigScreen.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement lblError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@text='Enter Password']")
        ));
        return lblError.getText();
    }
}