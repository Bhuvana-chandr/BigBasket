package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;

public class RadioButtonTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {

        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testRadioButtonSelection() {
        driver.get("https://www.bigbasket.com/pc/fruits-vegetables/exotic-fruits-veggies/");


        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('i-5%-10%').scrollIntoView()");


            WebElement radioButton = driver.findElement(By.id("i-5%-10%"));
            radioButton.click();
        // Add assertions or further actions as needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

