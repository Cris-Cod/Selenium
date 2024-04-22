import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.id("start")).click();

       //Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30).pollingEvery(Duration.ofMillis(300))

        Wait<WebDriver> wait = new FluentWait<>(driver)
                                .withTimeout(Duration.ofSeconds(2))
                                .pollingEvery(Duration.ofMillis(300))
                                .ignoring(NoSuchElementException.class);


    }
}
