package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private final WebDriver driver;
    private final By loginTitle = By.xpath(".//h2[text()='Вход']");
    private final By emailInput = By.xpath(".//input[@name='name']");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.className("button_button__33qZ0");
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By recoveryPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
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

    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickToRegistrationLink() {
        driver.findElement(registrationLink).click();
    }
    public void clickToRecoveryPasswordLink() {
        driver.findElement(recoveryPasswordLink).click();
    }
    public void login(String email, String password) {
        fillingEmailField(email);
        fillingPasswordField(password);
        clickToLoginButton();
    }

    public String getLoginTitleText() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(loginTitle).isEnabled()));
        return driver.findElement(loginTitle).getText();
    }

}
