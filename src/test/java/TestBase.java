import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;


    public boolean isElementPresent(By locator) {
        try {
            wait.until(WebDriver d) -> d.findElement(locator));
            return true;
        }
        catch (TimeoutException ex) {
            return false;
        }
    }

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        System.out.println(((HasCapabilities) driver).getCapabilities());
        driver.manage().window().maximize();

    }

    @AfterEach
    public void stop() {
        driver.manage().deleteAllCookies();
        if (driver != null) {
            driver.quit();
        }
    }


}
