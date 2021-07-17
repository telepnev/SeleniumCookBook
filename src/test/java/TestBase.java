import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        tlDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                })
        );

    }

    @AfterEach
    public void stop() {
//        driver.manage().deleteAllCookies();
//        if (driver != null) {
//            driver.quit();
//        }
    }
}

