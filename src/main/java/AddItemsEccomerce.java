import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class AddItemsEccomerce {
    public static void main(String[] args) throws InterruptedException {
        String [] namesVeges = {"Mango", "Raspberry", "Tomato", "Pumpkin"};

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   // Implicit wait
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(namesVeges, driver);
        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

    }

    public static void addItems(String [] namesVeges, WebDriver driver){
        List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < products.size(); i++){
            String name = products.get(i).getText();
            String [] nameFormat = name.split(" ");
            List vegies = Arrays.asList(namesVeges); //convert array in a list

            if(vegies.contains(nameFormat[0])){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(j==vegies.size()){
                    break;
                }
            }
        }

    }
}
