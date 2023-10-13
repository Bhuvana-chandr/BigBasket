package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MouseOver {
    public static void main(String[] args) {
        // Set up the logger
        Logger logger = Logger.getLogger(MouseOver.class.getName());

        System.setProperty("web-driver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");



        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/");

        try {
            WebElement linkElement = driver.findElement(By.cssSelector("a.LinearCollage___StyledLink-sc-179e50u-1.bLQAfV"));
            Actions actions = new Actions(driver);
            actions.moveToElement(linkElement).perform();

        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            logger.log(Level.SEVERE, "An error occurred:", e);
        } finally {
            driver.quit();
        }
    }
}
