package Project2;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserRegistrationLoginTest {

    @Test
    public void testUserRegistrationSuccess() {
        UserRegistrationLogin system = new UserRegistrationLogin();
        String result = system.registerUser("testUser", "testPass");
        assertEquals("Registration successful!", result);
    }

    @Test
    public void testUserRegistrationFailureDuplicate() {
        UserRegistrationLogin system = new UserRegistrationLogin();
        system.registerUser("existingUser", "pass123");
        String result = system.registerUser("existingUser", "pass456");
        assertEquals("Username already taken. Try a different one.", result);
    }

    @Test
    public void testLoginSuccess() {
        UserRegistrationLogin system = new UserRegistrationLogin();
        system.registerUser("loginUser", "loginPass");
        boolean loginResult = system.loginUser("loginUser", "loginPass");
        assertTrue(loginResult);
    }

    @Test
    public void testLoginFailureWrongPassword() {
        UserRegistrationLogin system = new UserRegistrationLogin();
        system.registerUser("loginUser", "loginPass");
        boolean loginResult = system.loginUser("loginUser", "wrongPass");
        assertFalse(loginResult);
    }
}
