package YaTranslate;

import YaTranslate.Pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class YaTranslate {

    protected static WebDriver driver;
    protected static MainPage page;

    @BeforeAll
    public static void initDriver() {
        System.setProperty("webdriver.gecko.driver","src/main/java/YaTranslate/Resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://translate.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page = new MainPage(driver);
    }

    @AfterAll
    public static void closeDriver(){
            driver.close();
    }
}
