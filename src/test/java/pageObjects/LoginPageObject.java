package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends BasePageObject {
    private final By email = By.xpath("//input[@name='name']");
    private final By password = By.xpath("//input[@name='Пароль']");
    private final By login = By.xpath("//button[text()='Войти']");

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