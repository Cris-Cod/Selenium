import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//div[@id='content']/ul/li[25]/a")).click();
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//div[@id='content']/div/div[1]"))).build().perform();
    }
}
