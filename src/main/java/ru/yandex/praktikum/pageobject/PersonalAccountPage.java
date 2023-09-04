package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private final WebDriver driver;

    private final By logOutButton = By.className("Account_button__14Yp3");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By mainLogoButton = By.className("AppHeader_header__logo__2D0X2");
    private final By personalAccountPageDescription = By.className("Account_text__fZAIn");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPersonalAccountPageDescription() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(personalAccountPageDescription).isEnabled()));
        return driver.findElement(personalAccountPageDescription).getText();
    }

    public void clickToConstructorButton() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(constructorButton).isEnabled()));
        driver.findElement(constructorButton).click();
    }

    public void clickToStellarLogoButton() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(mainLogoButton).isEnabled()));
        driver.findElement(mainLogoButton).click();
    }

    public void clickToLogOutButton() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(logOutButton).isEnabled()));
        driver.findElement(logOutButton).click();
    }
}
