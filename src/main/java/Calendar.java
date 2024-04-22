import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.findElement(By.name("ctl00$mainContent$txt_Todate")).isEnabled());
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();      // Select day in the calendar
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$txt_Todate")).isEnabled());
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }
}
