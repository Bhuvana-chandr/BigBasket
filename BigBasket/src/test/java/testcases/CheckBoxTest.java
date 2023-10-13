package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class CheckBoxTest {
    public WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testCheckBoxInteraction() throws InterruptedException {
        driver.get("https://www.bigbasket.com/pc/fruits-vegetables/exotic-fruits-veggies/");
        String parentHandle =driver.getWindowHandle();
        System.out.println(parentHandle);
        driver.switchTo().window(parentHandle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i-Rs21toRs50")));

        // Find a checkbox and click it

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('i-Rs21toRs50').scrollIntoView()");


        driver.findElement(By.id("i-Rs21toRs50")).click();


        // Add assertions or further actions as needed
    }

    @After
   public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
