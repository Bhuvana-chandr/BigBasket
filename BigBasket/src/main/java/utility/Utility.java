package utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Utility extends WebTestBase {
    static int i = 0;
    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD = 20;

    public static final long EXPLICIT_WAIT = 30;


    public static WebDriverWait wait;

    public static void waitUntillElementToBeClickable(WebElement element) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static String getTextOfElement(WebElement element) {

        return element.getText();

    }

    public static String getUrlOfSite() {

        return driver.getCurrentUrl();

    }

    public static void closeAllChildWindowsAndSwitchToParentWindow() {

        String parentWindow = driver.getWindowHandle();

        Set<String> allWindow = driver.getWindowHandles();

        for (String id : allWindow) {

            if (!(id.equals(parentWindow))) {
                driver.switchTo().window(id);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.close();
            }
            driver.switchTo().window(parentWindow);

        }
    }

    public static boolean isSelectedElement(WebElement element) {

       return element.isSelected();

    }
    public static boolean isDisplayedElement(WebElement element) {

        return element.isDisplayed();

    }

    public static void dropDownElement(List<WebElement> elements, String textToSearchInsideDropDown) {

        for(WebElement e:elements){

            if(e.getText().contains(textToSearchInsideDropDown)){
                System.out.println(e);
                 e.click();
            }

        }

    }

}