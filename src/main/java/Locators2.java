import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "rahul";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.tagName("p")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "You are successfully logged in.");
        String extrac_name = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        System.out.println(extrac_name);
        Assert.assertEquals(extrac_name, "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String [] passwordArray = passwordText.split("'");
        // String[] passwordArray2 = passwordArray[1].split("'");
        String password = passwordArray[1].split("'")[0];
        return password;
    }
}
