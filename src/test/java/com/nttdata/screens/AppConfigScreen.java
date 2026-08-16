package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppConfigScreen {

    public static AndroidDriver driver;

    private static final String APPIUM_URL = "http://127.0.0.1:4723/";

    public void iniciarAplicacion() {
        try {
            System.out.println("iniciarAplicacion");
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setUdid("emulator-5554");
            options.setDeviceName("PruebaMobile");
            options.setPlatformVersion("17");
            options.setApp("C:\\BizPartner_ABAP\\ExamenMobile\\apk\\mda-2.0.2-23.apk");
            options.setAppPackage("com.saucelabs.mydemoapp.android");
            options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
            options.setNoReset(true);
            options.setAutoGrantPermissions(true);
            options.setCapability("appium:forceAppLaunch", true);
            options.setCapability("appium:settings[waitForIdleTimeout]", 6000);
            options.setCapability("appium:disableWindowAnimation", true);
            options.setCapability("appium:skipLogcatCapture", true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            System.out.println("iniciarAplicacion - CONFIG");
            driver = new AndroidDriver(new URL(APPIUM_URL), options);

            System.out.println("Sesion Appium creada: " + driver.getSessionId());

        } catch (MalformedURLException e) {
            throw new RuntimeException("URL de Appium invalida", e);
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public void CerrarAplicacion() {
        if (driver != null) {
            try {
                System.out.println("Cerrando My Demo App...");
                driver.executeScript(
                        "mobile: terminateApp",
                        java.util.Map.of("appId", "com.saucelabs.mydemoapp.android")
                );
            } finally {
                System.out.println("Cerrando sesion Appium...");
                driver.quit();
                driver = null;
                System.out.println("Sesion Appium cerrada correctamente");
            }
        }
    }

    public byte[] TomarScreenshot() {
        if (driver == null) {
            return new byte[0];
        }
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}