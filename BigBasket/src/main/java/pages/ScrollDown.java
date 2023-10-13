package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScrollDown {
    public static void main(String[] args) {
        // Set up the logger
        Logger logger = Logger.getLogger(ScrollDown.class.getName());

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/");

        try {
            // Scroll down the page (you can adjust the pixel value as needed)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            logger.log(Level.SEVERE, "An error occurred:", e);
        } finally {
            driver.quit();
        }
    }
}
