import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class MaximiozingAndDeleteCookiesAndScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("aqdff");
        //sesion

        driver.get("https://google.com");

        //Take a screenShot

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File("C:\\Users\\USER\\IdeaProjects\\introduction-maven\\src\\main\\java\\google.png"));
    }
}
