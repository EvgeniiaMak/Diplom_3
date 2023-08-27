package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends AbstractTest {

    @Test
    public void goToBunsTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickToSaucesButton();
        mainPage.clickToBunsButton();

        boolean isEnabledSauces = mainPage.bunsDisplayed();
        assertTrue("Ошибка при переходе к разделу Булки", isEnabledSauces);
    }

    @Test
    public void goToSaucesTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickToSaucesButton();

        boolean isEnableSaucesChapter = mainPage.saucesDisplayed();
        assertTrue("Ошибка при переходе к разделу Соусы", isEnableSaucesChapter);
    }

    @Test
    public void goToFillingsTest() {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickToFillingsButton();

        boolean isEnabledFillings = mainPage.fillingsDisplayed();
        assertTrue("Ошибка при переходе к разделу Начинки", isEnabledFillings);
    }

}
