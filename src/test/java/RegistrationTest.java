import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import tools.Setup;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tools.UserProvider.delete;

public class RegistrationTest extends Setup {
    RegisterPageObject register;
    LoginPageObject login;

    @Before
    public void setUp() {
        startUp();
        register = new RegisterPageObject(driver);
        login = new LoginPageObject(driver);
    }

    @Test
    @DisplayName("Check registration with correct pass")
    public void correctRegistrationTest() {
        driver.get(REGISTER_PAGE_URL);
        register.register(NAME, EMAIL, PASSWORD);
        boolean isRegistered = register.checkRegister(EMAIL, PASSWORD);
        assertTrue("Failed registration with correct pass (" + PASSWORD + ") expected True, but was " + isRegistered,  isRegistered);
    }

    @Test
    @DisplayName("Check registration with wrong pass")
    public void wrongPassRegisterTest() {
        driver.get(REGISTER_PAGE_URL);
        register.register(NAME, EMAIL, PASSWORD);
        boolean isRegistered = register.checkRegister(EMAIL, WRONG_PASSWORD);
        assertFalse("Failed registration with wrong pass (" + WRONG_PASSWORD + ") expected False, but was " + isRegistered,  isRegistered);
    }

    @After
    public void cleanUp() {
        delete(EMAIL, PASSWORD);
        driver.quit();
    }
}