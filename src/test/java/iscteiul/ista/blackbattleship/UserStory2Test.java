
package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory2.
 * Tests the selection of the game mode against a robot.
 */
public class UserStory2Test {

    private WebDriver driver;
    private UserStory2 userStory2;

    /**
     * Initializes the browser and the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        userStory2 = new UserStory2(driver);
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Tests selecting the game mode against a robot.
     */
    @Test
    public void testSelectRobotMode() {
        userStory2.openGamePage();
        userStory2.acceptConsentIfPresent();
        userStory2.selectRobotMode();

        assertTrue(userStory2.isNicknameInputDisplayed(),
                "The nickname input field should be displayed.");
    }
}
