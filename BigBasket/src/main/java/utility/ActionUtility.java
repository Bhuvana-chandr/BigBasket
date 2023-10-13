package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.WebTestBase;

public class ActionUtility extends WebTestBase {

    public static void moveToElementFunctionality(WebElement Element){

        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }

}
