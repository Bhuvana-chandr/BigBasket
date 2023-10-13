package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MouseOverTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMouseOver() {
        driver.get("https://www.bigbasket.com/");

        WebElement elementToHover = driver.findElement(By.cssSelector("a.LinearCollage___StyledLink-sc-179e50u-1.bLQAfV"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();

        // Add assertions or further actions as needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


