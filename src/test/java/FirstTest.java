import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class FirstTest extends TestBase {
         WebDriverWait wait;

    @Test
    void myFirstTest() {
        driver.get("https://www.google.com/");

        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("webdriver");
        q.submit();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
