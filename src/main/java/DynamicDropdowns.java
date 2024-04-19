import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //  (//a[@value='MAA'])[2]    //a[@value='BLR']
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //     //div[@id= 'ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='MAA']   xpaht
        //     //div[@id= 'ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
    }
}
