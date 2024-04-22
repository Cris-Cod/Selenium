import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class CalendarUI {
    public static void main(String[] args) throws InterruptedException {

        String monthNumer = "6";
        String date = "22";
        String year = "2025";
        String [] expectList = {monthNumer, date, year};

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumer)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+ date +"']")).click();

        //System.out.println(driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).getText());
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectList[i]);
        }
        driver.close();
    }
}
