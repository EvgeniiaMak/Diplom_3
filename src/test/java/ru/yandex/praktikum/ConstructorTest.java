package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends AbstractTest {

    @Test
    public void goToBunsTest() throws InterruptedException {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickToSaucesButton();
        mainPage.clickToBunsButton();

        Thread.sleep(1000);

        int constructorPanelBottomLocation = mainPage.getConstructorPanelBottomLocation();
        int fillingsTitleLocation = mainPage.bunsChapterTitleLocationY();
        assertEquals("Ошибка при переходе к разделу Булки", fillingsTitleLocation, constructorPanelBottomLocation);
    }

    @Test
    public void goToSaucesTest() throws InterruptedException {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickToSaucesButton();

        Thread.sleep(1000);

        int constructorPanelBottomLocation = mainPage.getConstructorPanelBottomLocation();
        int fillingsTitleLocation = mainPage.saucesChapterTitleLocationY();
        assertEquals("Ошибка при переходе к разделу Соусы", fillingsTitleLocation, constructorPanelBottomLocation);
    }

    @Test
    public void goToFillingsTest() throws InterruptedException {
        driver.get(QA_STELLARBURGERS_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickToFillingsButton();

        Thread.sleep(1000);

        int constructorPanelBottomLocation = mainPage.getConstructorPanelBottomLocation();
        int fillingsTitleLocation = mainPage.fillingsChapterTitleLocationY();
        assertEquals("Ошибка при переходе к разделу Начинки", fillingsTitleLocation, constructorPanelBottomLocation);
    }

}
