package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.LoginPage;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.RegistrationPage;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.utils.TestConstants.*;

public class RegistrationTest extends AbstractTest {

    private static final Random random = new Random();

    @Test
    public void registrationTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickToLoginButton();
        loginPage.clickToRegistrationLink();
        String registrationLogin = String.format(REGISTRATION_EMAIL_TEMPLATE, random.nextInt());
        registrationPage.registration(REGISTRATION_NAME, registrationLogin, REGISTRATION_PASSWORD);

        String actual = loginPage.getLoginTitleText();
        assertTrue("Ошибка регистрации", actual != null && actual.startsWith(LOGIN_PAGE_TITLE_TEXT));
    }


    @Test
    public void registrationIncorrectPasswordTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickToLoginButton();
        loginPage.clickToRegistrationLink();
        String registrationLogin = String.format(REGISTRATION_EMAIL_TEMPLATE, random.nextInt());
        registrationPage.registration(REGISTRATION_NAME, registrationLogin, REGISTRATION_INCORRECT_PASSWORD);

        String actual = registrationPage.getIncorrectPasswordMessage();
        assertTrue("Ошибка регистрации", actual != null && actual.startsWith(INCORRECT_PASSWORD_ERROR_TEXT));
    }

}
