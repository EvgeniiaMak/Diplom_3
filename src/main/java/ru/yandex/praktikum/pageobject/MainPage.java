package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.utils.TestConstants.TEST_LOGIN;
import static ru.yandex.praktikum.utils.TestConstants.TEST_PASSWORD;

public class MainPage {
    private final WebDriver driver;
    private final By mainPageTitle = By.className("text_type_main-large");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By loginButton = By.className("button_button__33qZ0");
    private final By bunsButton = By.xpath(".//span[text()='Булки']/parent::div");
    private final By saucesButton = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']/parent::div");
    private final By bunsChapterTitle = By.xpath(".//h2[text()='Булки']");
    private final By saucesChapterTitle = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsChapterTitle = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickToPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public String getMainPageTitleText() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(mainPageTitle).isEnabled()));
        return driver.findElement(mainPageTitle).getText();
    }

    public void clickToBunsButton() {
        driver.findElement(bunsButton).click();
    }

    public void clickToSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    public void clickToFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    public boolean bunsDisplayed() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(bunsChapterTitle).isEnabled()));
        return driver.findElement(bunsChapterTitle).isDisplayed();
    }

    public boolean saucesDisplayed() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(saucesChapterTitle).isEnabled()));
        return driver.findElement(saucesChapterTitle).isDisplayed();
    }

    public boolean fillingsDisplayed() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(fillingsChapterTitle).isEnabled()));
        return driver.findElement(fillingsChapterTitle).isDisplayed();
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        clickToLoginButton();
        loginPage.login(TEST_LOGIN, TEST_PASSWORD);
    }
}
