package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final WebDriver driver;
    private final By loginTitle = By.xpath(".//h2[text()='Регистрация']");
    private final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/child::input");
    private final By emailInput = By.xpath(".//label[text()='Email']/parent::div/child::input");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By registrationButton = By.className("button_button__33qZ0");
    private final By loginLink = By.xpath(".//a[text()='Войти']");
    private final By errorLabel = By.className("input__error");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingEmailField(String email) {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(emailInput).isEnabled()));
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillingPasswordField(String password) {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(passwordInput).isEnabled()));
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void fillingNameField(String name) {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(nameInput).isEnabled()));
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void clickToRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickToLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String getIncorrectPasswordMessage() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(errorLabel).isEnabled()));
        return driver.findElement(errorLabel).getText();
    }

    public void checkTitleActive() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(loginTitle).isEnabled()));

    }

    public void registration(String name, String email, String password) {
        checkTitleActive();
        fillingNameField(name);
        fillingEmailField(email);
        fillingPasswordField(password);
        clickToLoginLink();
    }


}
