package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CheckBox{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));




        driver.get("https://www.bigbasket.com/pc/fruits-vegetables/exotic-fruits-veggies/");
        String parentHandle =driver.getWindowHandle();
        System.out.println(parentHandle);
        driver.switchTo().window(parentHandle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i-Rs21toRs50")));

            // Find a checkbox and click it

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('i-Rs21toRs50').scrollIntoView()");


         driver.findElement(By.id("i-Rs21toRs50")).click();

         Thread.sleep(2000);


          Thread.sleep(3000);
           driver.close();


    }
}
