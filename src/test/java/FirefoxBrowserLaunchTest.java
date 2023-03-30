import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class FirefoxBrowserLaunchTest {
    @Test
     void browserLaunchTest() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://fr.wikipedia.org/wiki/Selenium_IDE");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        System.out.println("This is the current URL : " + driver.getCurrentUrl());
        System.out.println("The title of the current page is :" + driver.getTitle());
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for(WebElement webElement : allLinks){
            String links = webElement.getAttribute("href");
            if (links!=null && !links.isEmpty()){
                System.out.println(links);
            }
        }
        System.out.println(allLinks.size());
        driver.quit();
    }
}
