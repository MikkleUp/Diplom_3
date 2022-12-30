package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageObject extends BasePageObject {
    private final By name = By.xpath("//label[text()='Имя']/../input");
    private final By email = By.xpath("//label[text()='Email']/../input");
    private final By password = By.xpath("//label[text()='Пароль']/../input");
    private final By register = By.xpath("//button[text()='Зарегистрироваться']");
    private final By login = By.xpath("//a[text() = 'Войти']");

    public RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    private WebElement getName() {
        return driver.findElement(name);
    }

    private WebElement getEmail() {
        return driver.findElement(email);
    }

    private WebElement getPassword() {
        return driver.findElement(password);
    }

    private WebElement getRegister() {
        return driver.findElement(register);
    }

    private WebElement getLogin() {
        return driver.findElement(login);
    }

    @Step("Register new user")
    public void register(String name, String email, String password) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        loadElement(getRegister());
        getRegister().click();
    }

    @Step("Check success register")
    public Boolean checkRegister(String email, String password) {
        LoginPageObject login = new LoginPageObject(driver);
        login.login(email, password);
        return login.checkLogin();
    }

    @Step("Press Login button")
    public void pressLogin() {
        loadElement(getLogin());
        getLogin().click();
    }
}