package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePageObject {
    protected final WebDriver driver;

    protected final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
    protected final By constructorButton = By.xpath("//p[text()='Конструктор']/..");
    protected final By accountProfileButton = By.xpath("//p[text()='Личный Кабинет']/..");

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
       WaitUtility.init(driver, 3);
    }
    protected void loadElement(WebElement waitElement) {
        WaitUtility.wait.until(ExpectedConditions.visibilityOf(waitElement));
    }

    protected void doRedirect(String urlContains) {
        WaitUtility.wait.until(ExpectedConditions.urlContains(urlContains));
    }

    protected void clickElementWithSleep(WebElement element) {
        try {
            Thread.sleep(1000);
            WaitUtility.wait.until(ExpectedConditions.elementToBeClickable(element)).click();;
        } catch(Exception ignored) {

        }
    }

    protected WebElement getConstructorButton() {
        return driver.findElement(constructorButton);
    }

    protected WebElement getAccountProfileButton() {
        return driver.findElement(accountProfileButton);
    }

    private WebElement getLogo() {
        return driver.findElement(logo);
    }

    @Step("Press Profile button")
    public void pressAccountProfileButton() {
        loadElement(getAccountProfileButton());
        getAccountProfileButton().click();
    }

    @Step("Press logo")
    public void pressStellarLogo() {
        loadElement(getLogo());
        getLogo().click();
    }

    @Step("Press Constructor button")
    public void pressConstructorButton() {
        loadElement(getConstructorButton());
        getConstructorButton().click();
    }
}