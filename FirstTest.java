package Anderson.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
    }

    @Test
    public void searchWeather() {
        WebElement searchField = driver.findElement(By.id("text"));
        searchField.sendKeys("погода Пенза", Keys.ENTER);
        WebElement firstResult = driver.findElement(By.cssSelector(".organic__url-text"));
        String firstResultText = firstResult.getText();
        Assert.assertTrue(firstResultText.contains("Погода"));

    }
    
    @AfterClass
    public static void finish() {
        driver.quit();
    }


}
