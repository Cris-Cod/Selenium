import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfIntroduction  {
    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       // WebDriver  driver = new ChromeDriver();


        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://courses.rahulshettyacademy.com/courses/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }


}
