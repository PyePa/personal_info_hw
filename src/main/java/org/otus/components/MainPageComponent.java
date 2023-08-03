package org.otus.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageComponent extends AbsBaseComponent {

    public MainPageComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sc-mrx253-0")
    private WebElement loginButton;

    @FindBy(css = ".sc-199a3eq-0")
    private WebElement userIcon;

    @FindBy(xpath = "//a[contains(text(),'Мой профиль')]")
    private WebElement userProfileButton;

    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[3]")
    private WebElement buttonProfile;


    public void moveCoursorOnUserIcon() {
        actions.moveToElement(userIcon).build().perform();
    }

    public void clickUserProfile(){
        userProfileButton.click();
    }
    public MainPageComponent clickButtonLogin(){
        loginButton.click();
        return new MainPageComponent(driver);
    }


}