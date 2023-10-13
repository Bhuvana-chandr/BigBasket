package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class WindowsHandlesTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWindowHandles() throws InterruptedException {
        driver.get("https://www.bigbasket.com/");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parent window handle:"+parentWindowHandle);
        Thread.sleep(3000);

        // Perform actions to open a new window
        driver.findElement(By.xpath("//div[@class='LinearCollage___StyledDiv-sc-179e50u-0 ksbtjv']/following::a[2]")).click();


        Set<String> windowHandles = driver.getWindowHandles();
        for(String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
                System.out.println("Child window handle:"+windowHandle);
                driver.findElement(By.xpath("//span[text()='Shop Now']"));
            }
        }

        // Add assertions or further actions as needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

