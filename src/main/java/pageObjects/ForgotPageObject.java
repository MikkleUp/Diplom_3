package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPageObject extends BasePageObject {
    private final By login = By.xpath("//a[text()='Войти']");

    public ForgotPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Press Login")
    public void pressLogInLink() {
        loadElement(driver.findElement(login));
        driver.findElement(login).click();
    }
}