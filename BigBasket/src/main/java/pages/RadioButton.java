package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RadioButton{
    public static void main(String[] args) {
        // Set up the logger
        Logger logger = Logger.getLogger(RadioButton.class.getName());

        WebDriverManager.firefoxdriver().setup();


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/pc/fruits-vegetables/exotic-fruits-veggies/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('i-5%-10%').scrollIntoView()");

        try {
            // Find a radio button and click it
            WebElement radioButton = driver.findElement(By.id("i-5%-10%"));
            radioButton.click();

        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            logger.log(Level.SEVERE, "An error occurred:", e);
        } finally {
            driver.quit();
        }
    }
}
