package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginLink() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(loginLink).isEnabled()));
        driver.findElement(loginLink).click();
    }

}
