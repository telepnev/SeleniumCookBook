import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase {

    @Test
    void loginTest() {
        driver.get("http://localhost/litecart/admin/");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");
        driver.findElement(By.name("login")).click();
    }

}
