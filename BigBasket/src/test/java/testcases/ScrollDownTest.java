package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScrollDownTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testScrollDown() {
        driver.get("https://www.bigbasket.com/");

        String script = "window.scrollTo(0, document.body.scrollHeight)";
        ((JavascriptExecutor) driver).executeScript(script);

        // Add assertions or further actions as needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
