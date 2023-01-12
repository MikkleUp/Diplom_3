package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public static WebDriverWait wait = null;

    public static void init(WebDriver driver, long timeoutDuration) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutDuration));
    }
}
