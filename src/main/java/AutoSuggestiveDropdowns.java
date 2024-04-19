import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("br");
        Thread.sleep(2000);
        List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        driver.findElement(By.id("autosuggest")).sendKeys(Keys.DOWN);

        JavascriptExecutor js=(JavascriptExecutor)driver;

        String script="return document.getElementById(\"autosuggest\").value;";

        String text=(String) js.executeScript(script);

        System.out.println(text);

        int i=0;

        while(!text.equalsIgnoreCase("Gibraltar"))

        {

            i++;

            Thread.sleep(2000);

           WebElement country = driver.findElement(By.id("autosuggest"));
           country.sendKeys(Keys.DOWN);

            text=(String)js.executeScript(script);



            if(i>options.size())

            {

                break;

            }

            if(text.equalsIgnoreCase("Gibraltar")){
                country.sendKeys(Keys.ENTER);
            }
        }

    }
}
