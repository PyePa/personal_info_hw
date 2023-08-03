package org.otus.components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageComponent extends AbsBaseComponent {


    public LoginPageComponent(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN = System.getProperty("login");
    private final static String PASSWORD = System.getProperty("password");


    @FindBy(css = "[name=email]")
    private WebElement loginTextBox;

    @FindBy(css = "[type=password]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//div[contains(text(),'Войти')]")
    private WebElement loginButton;

    private String inputTextBox = "[name=email]";

    private String loginModalWindow = "//div[contains(text(),'Войти')]";

    public void waitVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(inputTextBox))).isDisplayed());
    }

    public void waitClickInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loginModalWindow))));
    }

    public void authorizationUser() {
        loginTextBox.sendKeys(LOGIN);
        passwordTextBox.sendKeys(PASSWORD);
        loginButton.click();
    }

}