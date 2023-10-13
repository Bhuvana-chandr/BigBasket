package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchLogin {
    public static void main(String[] args) {
        // Set up the logger
        Logger logger = Logger.getLogger(SearchLogin.class.getName());

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/");

        try {
            // Find the search box element and enter "login"

            String parentWindowHandle = driver.getWindowHandle();
            System.out.println("parent window handle:"+parentWindowHandle);
            Thread.sleep(3000);

            driver.findElement(By.xpath("//button[text()='Login/ Sign Up']")).click();
          WebElement searchBox =  driver.findElement(By.id("multiform"));
          searchBox.sendKeys("bhuvanachandra7569@gmail.com");
          searchBox.submit();
            Thread.sleep(3000);


            WebElement enterNum =  driver.findElement(By.id("verifyform"));
            enterNum.sendKeys("7569275650");
            enterNum.submit();


        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            logger.log(Level.SEVERE, "An error occurred:", e);
        } finally {
            driver.quit();
        }
    }
}
