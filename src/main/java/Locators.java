import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        //Implicit wait -- 2seconds time out
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jonh");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jonh@ser.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@type = 'text'][2]")).sendKeys("jonhDoe@ser.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("365555993");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();





        //Css Selector
        // class name -> tagname.classname  - p.error
        // ic -> tagname#id -> input<
        // Tagname[attribute='value']   ---- input[placeholder='Email']
        // input[placeholder = 'username']
        // input[type='text']:nth-child(3)
        // .reset-pwd-btn   --- .classname
        // form p          ----- parentagname childtagname
        //  .ui-state-default.ui-state-highlight.ui-state-active     -- put dat (.) after each class

        // Regular expresion - input[type*='pass']

        /*
        * Xpath
        *  //Tagname[@attribute='value']
        *  //input[@placeholder='value']  -- //input[@placeholder='Name']
        *  //input[@type = 'text'][2]
        *  //form/input[3]
        *  //button[contains(@class, 'submit')]   --- Regular expresion
        *  //div[@class = 'forgot-pwd-btn-conainer']/button[1]
        *  //button[text()='Log Out']
        *  //*[text()='Log Out']
        *  (//a[@value='MAA'])[2]
        *   //DIV[@id= 'ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']     -- Traversing parent to chlid
         */





        /* Sibling - Child to parent traverse
        *   //header/div/button[1]/following-sibling::button[1]   -- sibling traverse
        *   //header/div/button[1]/parent::div      --- child traverse to parent
        * */

    }


}
