/*package com.nttdata.screens.old;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class LoginScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    private WebElement btnClose;

    public void clickClose(){

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btnClose));
        getDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(2));

        btnClose.click();



    }
}
*/