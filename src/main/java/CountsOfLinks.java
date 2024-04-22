import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class CountsOfLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Give me the count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement columnlinks = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnlinks.findElements(By.tagName("a")).size());
        for (int i = 1; i < columnlinks.findElements(By.tagName("a")).size(); i++) {
            String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columnlinks.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
            Thread.sleep(5000);

        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext())

        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
