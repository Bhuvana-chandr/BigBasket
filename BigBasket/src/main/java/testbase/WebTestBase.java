package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public static WebDriver driver;
    public static Properties prop;


    public  WebTestBase(){
        prop = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void initialization(){

        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeoption = new ChromeOptions();
            chromeoption.addArguments("--remote-allow-origins=*");
            chromeoption.setBinary("C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
            System.setProperty("web-driver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver(chromeoption);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            edgeOptions.setBinary("C:/Program Files (x86)/Microsoft/Edge/Application/ms-edge.exe");

            System.setProperty("web-driver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver(edgeOptions);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\\\Users\\\\hp\\\\Downloads\\\\geckodriver-v0.33.0-win64\\\\geckodriver.exe");
            System.setProperty("web-driver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver(firefoxOptions);
        }
        else {

            throw new RuntimeException("please select correct browser name");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.IMPLICIT_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.PAGE_LOAD));
        driver.manage().deleteAllCookies();
    }

}

