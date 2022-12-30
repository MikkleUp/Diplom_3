package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {
    protected final WebDriver driver;
    protected final int timeoutDuration;
    protected final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
    protected final By constructorButton = By.xpath("//p[text()='Конструктор']/..");
    protected final By accountProfileButton = By.xpath("//p[text()='Личный Кабинет']/..");

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        timeoutDuration = 3;
    }

    protected void loadElement(WebElement waitElement) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutDuration)).until(ExpectedConditions.visibilityOf(waitElement));
    }

    protected void doRedirect(String urlContains) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(urlContains));
    }

    protected WebElement getConstructorButton() {
        return driver.findElement(constructorButton);
    }

    protected WebElement getAccountProfileButton() {
        return driver.findElement(accountProfileButton);
    }

    @Step("Press Profile button")
    public void pressAccountProfileButton() {
        loadElement(getAccountProfileButton());
        getAccountProfileButton().click();
    }

    @Step("Press logo")
    public void pressStellarLogo() {
        loadElement(driver.findElement(logo));
        driver.findElement(logo).click();
    }

    @Step("Press Constructor button")
    public void pressConstructorButton() {
        loadElement(getConstructorButton());
        getConstructorButton().click();
    }
}