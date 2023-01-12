package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageObject extends BasePageObject {
    private final By profile = By.xpath("//a[text()='Профиль']");
    private final By signOut = By.xpath("//button[text()='Выход']");

    public ProfilePageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getProfile() {
        return driver.findElement(profile);
    }

    public WebElement getSignOut() {
        return driver.findElement(signOut);
    }

    @Step("Press SingOut button")
    public void signOut() {
        doRedirect("account/profile");
        loadElement(getSignOut());
        getSignOut().click();
        doRedirect("/login");
    }

    @Step("Check visibility")
    public Boolean checkAccountProfileEnabled() {
        doRedirect("account/profile");
        loadElement(getProfile());
        return getProfile().isDisplayed();
    }
}