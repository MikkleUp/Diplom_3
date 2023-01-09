package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static tools.Setup.HOME_PAGE_URL;

public class LoginPageObject extends BasePageObject {
    private final By email = By.xpath("//input[@name='name']");
    private final By password = By.xpath("//input[@name='Пароль']");
    private final By login = By.xpath("//button[text()='Войти']");

    private final By modal = By.xpath("//*[@id=\"root\"]/div/div");

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    private WebElement getEmail() {
        return driver.findElement(email);
    }

    private WebElement getPassword() {
        return driver.findElement(password);
    }

    private WebElement getLogin() {
        return driver.findElement(login);
    }

    @Step("Login")
    public void login(String email, String password) {
        doRedirect("/login");
        loadElement(getEmail());
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLogin().click();
        new WebDriverWait(driver, Duration.ofSeconds(timeoutDuration));
    }

    @Step("Check success login")
    public Boolean checkLogin() {
        pressStellarLogo();
        HomePageObject home = new HomePageObject(driver);

        try {
            return home.getOrderButton().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}