package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.LoginPage;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.PersonalAccountPage;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.utils.TestConstants.*;

public class PersonalAccountPageTest extends AbstractTest {

    @Test
    public void goToPersonalAccountPageTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.login();

        mainPage.clickToPersonalAccountButton();

        String actual = personalAccountPage.getPersonalAccountPageDescription();
        assertTrue("Ошибка перехода в личный кабинет", actual != null && actual.startsWith(PERSONAL_ACCOUNT_PAGE_DESCRIPTION_TEXT));
    }

    @Test
    public void goToConstructorByConstructorButtonTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.login();

        mainPage.clickToPersonalAccountButton();

        personalAccountPage.clickToConstructorButton();

        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка при переходе на главную страницу", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

    @Test
    public void goToConstructorLogoStellarTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.login();

        mainPage.clickToPersonalAccountButton();

        personalAccountPage.clickToStellarLogoButton();
        String actual = mainPage.getMainPageTitleText();
        assertTrue("Ошибка при переходе на главную страницу", actual != null && actual.startsWith(MAIN_PAGE_TITLE_TEXT));
    }

    @Test
    public void logOutTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.login();

        mainPage.clickToPersonalAccountButton();

        personalAccountPage.clickToLogOutButton();
        String actual = loginPage.getLoginTitleText();
        assertTrue("Ошибка выхода", actual != null && actual.startsWith(LOGIN_PAGE_TITLE_TEXT));
    }

}
