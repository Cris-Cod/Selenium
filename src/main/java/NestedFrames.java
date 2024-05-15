import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");
        var size = driver.findElement(By.tagName("iframe")).getSize();
        System.out.println("number of iframe" + size);
        driver.switchTo().frame(0);
        var text = driver.findElement(By.cssSelector("body p")).getText();
        System.out.println(text);

    }




}
