import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.ProfilePageObject;
import pageObjects.RegisterPageObject;
import tools.Setup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tools.UserProvider.delete;

public class ProfileTest extends Setup {
    RegisterPageObject register;
    HomePageObject home;
    LoginPageObject login;
    ProfilePageObject profile;

    @Before
    public void setUp() {
        startUp();
        home = new HomePageObject(driver);
        login = new LoginPageObject(driver);
        profile = new ProfilePageObject(driver);

        driver.get(REGISTER_PAGE_URL);
        register = new RegisterPageObject(driver);
        register.register(NAME, EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Check ProfilePage")
    public void moveToAccountProfileFromHomePage() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        assertTrue("Failed Profile Page", profile.checkAccountProfileEnabled());
    }

    @Test
    @DisplayName("Check SingOut button")
    public void signOutButtonTest() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.signOut();
        String currentURL = driver.getCurrentUrl();
        assertEquals("Failed SingOut. Expected URL " + LOGIN_PAGE_URL + ", but was " + currentURL, LOGIN_PAGE_URL, currentURL);
    }

    @Test
    @DisplayName("Check logo redirect")
    public void moveToConstructorFromAccountProfileByLogo() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.pressStellarLogo();
        String currentURL = driver.getCurrentUrl();
        assertEquals("Failed logo redirect. Expected URL " + HOME_PAGE_URL + ", but was " + currentURL, HOME_PAGE_URL, currentURL);
    }

    @Test
    @DisplayName("Check Constructor button")
    public void moveToConstructorFromAccountProfileByConstructorButton() {
        driver.get(LOGIN_PAGE_URL);
        login.login(EMAIL, PASSWORD);
        home.pressAccountProfileButton();
        profile.pressConstructorButton();
        String currentURL = driver.getCurrentUrl();
        assertEquals("Failed Constructor. Expected URL " + HOME_PAGE_URL + ", but was " + currentURL, HOME_PAGE_URL, currentURL);
    }

    @After
    public void cleanUp() {
        delete(EMAIL, PASSWORD);
        driver.quit();
    }
}
