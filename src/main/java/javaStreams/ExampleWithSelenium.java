package javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleWithSelenium {

    //covert Sorting and pagination
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> elememts = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        //elememts.forEach(s-> System.out.println(s));
        List<String> sortedList = elememts.stream().sorted().collect(Collectors.toList());
        //sortedList.stream().forEach(s-> System.out.println(s));
        Assert.assertTrue(elememts.equals(sortedList));

        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (price.size() < 1);
    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return priceValue;
    }
}
