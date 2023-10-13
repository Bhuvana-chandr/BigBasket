package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;

public class SearchLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSearchLogin() throws InterruptedException {
        driver.get("https://www.bigbasket.com/");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parent window handle:"+parentWindowHandle);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Login/ Sign Up']")).click();
        WebElement searchBox =  driver.findElement(By.id("multiform"));
        searchBox.sendKeys("bhuvanachandra7569@gmail.com");
        searchBox.submit();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyform")));


        WebElement enterNum =  driver.findElement(By.id("verifyform"));
        enterNum.sendKeys("7569275650");
        enterNum.submit();

        // Add assertions or further actions as needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

