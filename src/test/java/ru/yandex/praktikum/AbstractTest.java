package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.pageobject.LoginPage;
import ru.yandex.praktikum.pageobject.MainPage;

import static ru.yandex.praktikum.utils.TestConstants.TEST_LOGIN;
import static ru.yandex.praktikum.utils.TestConstants.TEST_PASSWORD;

public abstract class AbstractTest {

    static final String QA_STELLARBURGERS_URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;

    @Before
    public void startUp() {
        if ("yandex".equals(System.getProperty("browser"))) {
            WebDriverManager.chromedriver().driverVersion(System.getProperty("YaBrowserDriverVersion")).setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary(System.getProperty("YaBrowserLocation"));
            driver = new ChromeDriver(options);
            System.out.println("YANDEX!!");
        } else if ("firefox".equals(System.getProperty("browser"))) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            System.out.println("Firefox!!");
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            System.out.println("Chrome");
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
