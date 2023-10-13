package utility;

import org.openqa.selenium.JavascriptExecutor;
import testbase.WebTestBase;

public class JavaScriptExecutorUtility extends WebTestBase {

    public static void scrollToElement(String aurgument){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(aurgument);
    }

}
