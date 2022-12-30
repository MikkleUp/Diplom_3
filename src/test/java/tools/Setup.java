package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    protected WebDriver driver;
    public static String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static String FORGOT_PASS_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static String NAME = "Lexus666";
    public static String EMAIL = "IamLexus666@mail.ru";
    public static String PASSWORD = "Qwert666";
    public static String WRONG_PASSWORD = "222546734";

    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
