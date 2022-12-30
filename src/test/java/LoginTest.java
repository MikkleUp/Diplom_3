import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.ForgotPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import tools.Setup;

import static org.junit.Assert.assertTrue;
import static tools.UserProvider.delete;

public class LoginTest extends Setup {
    RegisterPageObject register;
    HomePageObject home;
    LoginPageObject login;
    ForgotPageObject forgot;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver);
        login = new LoginPageObject(driver);
        forgot = new ForgotPageObject(driver);

        driver.get(REGISTER_PAGE_URL);
        register = new RegisterPageObject(driver);
        register.register(NAME, EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("HomePage login")
    public void loginFromAccountProfileButton() {
        driver.get(HOME_PAGE_URL);
        home.pressLogInButton();
        login.login(EMAIL, PASSWORD);
        assertTrue("Failed HomePage login ("+ EMAIL + " " + PASSWORD + ") expected True, but was False", login.checkLogin());
    }

    @Test
    @DisplayName("Profile login")
    public void logInFromAccountProfileButton() {
        driver.get(HOME_PAGE_URL);
        home.pressAccountProfileButton();
        login.login(EMAIL, PASSWORD);
        assertTrue("Failed Profile login ("+ EMAIL + " " + PASSWORD + ") expected True, but was False", login.checkLogin());
    }

    @Test
    @DisplayName("Registration login")
    public void logInFromRegistrationForm() {
        driver.get(REGISTER_PAGE_URL);
        register.pressLogin();
        login.login(EMAIL, PASSWORD);
        assertTrue("Failed Registration login ("+ EMAIL + " " + PASSWORD + ") expected True, but was False", login.checkLogin());
    }

    @Test
    @DisplayName("ForgotPass login")
    public void logInFromForgotPassPageLink() {
        driver.get(FORGOT_PASS_URL);
        forgot.pressLogInLink();
        login.login(EMAIL, PASSWORD);
        assertTrue("Failed ForgotPass login ("+ EMAIL + " " + PASSWORD + ") expected True, but was False", login.checkLogin());
    }

    @After
    public void cleanUp() {
        delete(EMAIL, PASSWORD);
        driver.quit();
    }
}