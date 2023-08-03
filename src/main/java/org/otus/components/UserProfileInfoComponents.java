package org.otus.components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.otus.data.ProfileData.*;


import java.util.List;

public class UserProfileInfoComponents extends AbsBaseComponent {
    public UserProfileInfoComponents(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_fname")
    private WebElement firstNameField;

    @FindBy(id = "id_fname_latin")
    private WebElement firstNameLatinField;

    @FindBy(id = "id_lname")
    private WebElement secondNameField;

    @FindBy(id = "id_lname_latin")
    private WebElement secondNameLatinField;

    @FindBy(id = "id_blog_name")
    private WebElement blogNameField;

    @FindBy(css = "input[name = date_of_birth]")
    private WebElement birthDateField;

    @FindBy(css = "button[title='Россия']")
    private WebElement countrySelection;

    //Город
    @FindBy(xpath = "//input[contains(@data-title,'Город') and not(@disabled='disabled')]")
    private WebElement cityFieldWait;

    @FindBy(xpath = "//input[@data-title='Город']/parent::label/parent::div")
    private WebElement cityField;

    @FindBy(css = "button[title='Пенза']")
    private WebElement citySelection;

    //Уровень языка
    @FindBy(xpath = "//input[@data-title='Уровень знания английского языка']/parent::label/parent::div")
    private WebElement languageField;

    @FindBy(css = "button[title='Выше среднего (Upper Intermediate)']")
    private WebElement languageSelection;

    //Готовность к переезду
    @FindBy(xpath = "//input[@id='id_ready_to_relocate_0']//following-sibling::span")
    private WebElement relocateRadioButton;

    @FindBy(css = "input[id='id_ready_to_relocate_0']")
    private WebElement relocateRadioButtonChecked;

    //Формат работы
    @FindBy(xpath = "//input[@title='Полный день']/parent::label/span")
    private WebElement workFormatCheckBox;

    @FindBy(css = "input[title='Полный день']")
    private WebElement workFormatCheckBoxChecked;

    //Способы связи
    @FindBy(xpath = "//input[@name='contact-0-service']/following-sibling::div")
    private WebElement сommunicationFieldOne;

    @FindBy(css = "button[data-value='skype']")
    private WebElement сommunicationSelectionOne;

    @FindBy(css = "input[id='id_contact-0-value']")
    private WebElement сontactOneField;

    @FindBy(xpath = "//input[@name='contact-1-service']/following-sibling::div")
    private WebElement сommunicationFieldTwo;

    @FindBy(xpath = "//input[@name='contact-1-service']/parent::label/following-sibling::div/descendant::button[@data-value='telegram']")
    private WebElement сommunicationSelectionTwo;

    @FindBy(css = "input[id='id_contact-1-value']")
    private WebElement contactTwoField;

    //Пол
    @FindBy(css = "select[id='id_gender']")
    private WebElement gendersField;

    @FindBy(css = "option[value='f']")
    private WebElement genderSelection;

    //Компания
    @FindBy(css = "input[id='id_company']")
    private WebElement companyField;

    //Должость
    @FindBy(css = "input[id='id_work']")
    private WebElement positionField;

    //Опыт разработки
    @FindBy(css = "select[id ='id_experience-0-experience']")
    private WebElement experienceField;

    @FindBy(xpath = "//option[text()='Java']")
    private WebElement experienceSelection;

    @FindBy(css = "select[id ='id_experience-0-level']")
    private WebElement experienceLevelField;

    @FindBy(xpath = "//option[text()='Более 10 лет']")
    private WebElement experienceLevelSelection;

    @FindBy(css = "button[name='continue']")
    private WebElement saveButton;


    @FindBy(xpath = "//input[@id='id_contact-4-value']")
    private WebElement fieldContact1;

    @FindBy(xpath = "//input[@id='id_contact-5-value']")
    private WebElement fieldContact2;

    @FindBy(xpath = "//span[contains(text(),'Способ связи')]")
    private WebElement selectDropdownListContact;

    @FindBy(css = "button[title = 'Сохранить и продолжить']")
    private WebElement saveAndContinueButton;

    @FindBy(className = "js-lk-cv-custom-select-add")
    private WebElement buttonAddNewContact;
    @FindBy(xpath = "//div[contains(@class,'container__col_md-0')]//button[contains(text(),'Удалить')]")
    private List<WebElement> deleteButtonsList;


    @FindBy(css = "[class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select']")
    private WebElement languageLevelDropdown;


    private String dropdownContacts = ("(//button[@data-value='%s'])[last()]");

    private String setLanguageLevel = ("//button[contains(text(),'Элементарный уровень (Elementary)')]");  //*[contains(text(), '%s')]

    private void inputUserInfo(WebElement webElement, UserInfoData userInfoData) {
        webElement.clear();
        webElement.sendKeys(userInfoData.getName());
    }

    public void inputContactInfo(WebElement webElement, ContactsFieldData contactsFieldData) {
        webElement.clear();
        webElement.sendKeys(contactsFieldData.getName());
    }

    public void fillFieldsInfo() {
        inputUserInfo(firstNameField, UserInfoData.FIRST_NAME);
        inputUserInfo(firstNameLatinField, UserInfoData.FIRST_NAME_LATIN);
        inputUserInfo(secondNameField, UserInfoData.SECOND_NAME);
        inputUserInfo(secondNameLatinField, UserInfoData.SECOND_NAME_LATIN);
        inputUserInfo(blogNameField, UserInfoData.BLOG_NAME);
        inputUserInfo(birthDateField, UserInfoData.BIRTH_DATE);
    }

    public UserProfileInfoComponents fillContactInfo() {
        inputContactInfo(fieldContact1, ContactsFieldData.CONTACT1);
        return new UserProfileInfoComponents(driver);
    }


    public void clickContactDropdownList() {
        selectDropdownListContact.click();

    }

    public void clickSaveAndContinueButton() {
        saveAndContinueButton.click();
    }

    public void clickButtonAddNewContact() {
        buttonAddNewContact.click();
    }

    public UserProfileInfoComponents deleteCommunicationMethodsIfExist() {
        if (deleteButtonsList != null) {
            String personalURL = driver.getCurrentUrl();
            for (WebElement deleteButton : deleteButtonsList) {
                deleteButton.click();
            }
        }
        return new UserProfileInfoComponents(driver);


    }


    public UserProfileInfoComponents selectContact(ContactsData contactsData) {

        String locator = String.format(dropdownContacts, contactsData.getName());
        WebElement dropdownList = driver.findElement(By.xpath(locator));
        dropdownList.click();

        return this;
    }


    private UserProfileInfoComponents selectLanguageLevel(LanguageLevelData languageLevelData) {

        String locator = String.format(setLanguageLevel, languageLevelData.getName());
        WebElement setLanguageLevelElement = driver.findElement(By.xpath(locator));

        setLanguageLevelElement.click();

        return this;
    }

    public void clickLanguageLevelDropdown() {

        selectLanguageLevel(LanguageLevelData.ELEMENTARY);
    }

    public void checkInfoData() {
        Assertions.assertEquals(UserInfoData.FIRST_NAME.getName(), firstNameField.getAttribute("value"));
        Assertions.assertEquals(UserInfoData.FIRST_NAME_LATIN.getName(), firstNameLatinField.getAttribute("value"));
        Assertions.assertEquals(UserInfoData.SECOND_NAME.getName(), secondNameField.getAttribute("value"));
        Assertions.assertEquals(UserInfoData.SECOND_NAME_LATIN.getName(), secondNameLatinField.getAttribute("value"));
        Assertions.assertEquals(UserInfoData.BLOG_NAME.getName(), blogNameField.getAttribute("value"));
        Assertions.assertEquals(UserInfoData.BIRTH_DATE.getName(), birthDateField.getAttribute("value"));
    }

}