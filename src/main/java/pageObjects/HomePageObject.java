package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePageObject {
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bun = By.xpath("//span[text() = 'Булки']");
    private final By sauce = By.xpath("//span[text() = 'Соусы']");
    private final By filling = By.xpath("//span[text() = 'Начинки']");
    private final By bunSelected = By.xpath("//span[text()='Булки']/..");
    private final By sauceSelected = By.xpath("//span[text()='Соусы']/..");
    private final By fillingSelected = By.xpath("//span[text()='Начинки']/..");
    private final By constructor = By.xpath("//div[@style='display: flex;']/div");

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    private WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    @Step("Return current class attribute")
    public String getCurrentClassAttributeValue() {
        return "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
    }

    @Step("Get Bun Class name")
    public String getBunClassName() {
        driver.findElement(filling).click();
        driver.findElement(bun).click();
        return driver.findElement(constructor).findElement(bunSelected).getAttribute("class");
    }

    @Step("Get Sauce Class name")
    public String getSauceClassName() {
        driver.findElement(filling).click();
        driver.findElement(sauce).click();
        return driver.findElement(constructor).findElement(sauceSelected).getAttribute("class");
    }

    @Step("Get Filling Class name")
    public String getFillingClassName() {
        driver.findElement(sauce).click();
        driver.findElement(filling).click();
        return driver.findElement(constructor).findElement(fillingSelected).getAttribute("class");
    }

    @Step("Press Login button")
    public void pressLogInButton() {
        loadElement(getLoginButton());
        getLoginButton().click();
    }
}