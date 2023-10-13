package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowHandles {
    public static void main(String[] args) {
        // Set up the logger
        Logger logger = Logger.getLogger(WindowHandles.class.getName());

        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");



        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/");

        try {
            // Open a new window or tab

            String parentWindowHandle = driver.getWindowHandle();

            // Get all window handles
            Set<String> windowHandles = driver.getWindowHandles();
            for(String windowHandle : windowHandles) {
                if (windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println(windowHandle);
                }
            }
        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            logger.log(Level.SEVERE, "An error occurred:", e);
        } finally {
            driver.quit();
        }
    }
}