package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;


import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.utils.TestConstants.*;

public class LoginTest extends AbstractTest {

    @Test
    public void loginMaiLogInButton() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickToLoginButton();
        loginPage.login(TEST_LOGIN, TEST_PASSWORD);

        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка входа", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

    @Test
    public void loginPersonalAccountButton() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickToPersonalAccountButton();

        loginPage.login(TEST_LOGIN, TEST_PASSWORD);

        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка входа", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

    @Test
    public void loginFromRegistrationFormButton() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickToLoginButton();
        loginPage.clickToRegistrationLink();
        registrationPage.clickToLoginLink();

        loginPage.login(TEST_LOGIN, TEST_PASSWORD);
        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка входа", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

    @Test
    public void loginFromPasswordRecoveryFormButton() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        mainPage.clickToLoginButton();
        loginPage.clickToRecoveryPasswordLink();
        passwordRecoveryPage.clickToLoginLink();

        loginPage.login(TEST_LOGIN, TEST_PASSWORD);
        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка входа", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

}
