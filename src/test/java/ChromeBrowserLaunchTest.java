import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class ChromeBrowserLaunchTest {
@Test
 void browserLaunchTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement oneWay = driver.findElement(By.id("nav-cart-count"));
        oneWay.click();
        sleep(2000);
        System.out.println("This is the current URL : " + driver.getCurrentUrl());
        System.out.println("The title of the current page is :" + driver.getTitle());

        driver.quit();

    }

}
