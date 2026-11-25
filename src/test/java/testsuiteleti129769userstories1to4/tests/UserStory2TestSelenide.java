
package testsuiteleti129769userstories1to4.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testsuiteleti129769userstories1to4.pages.UserStory2Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory2 using Selenide.
 * Tests the selection of the game mode against a robot.
 */
public class UserStory2TestSelenide {

    private UserStory2Selenide userStory2;

    /**
     * Initializes the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        userStory2 = new UserStory2Selenide();
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Tests selecting the game mode against a robot.
     */
    @Test
    public void testSelectRobotMode() {
        userStory2.openGamePage();
        userStory2.acceptConsentIfPresent();
        userStory2.selectRobotMode();

        userStory2.shouldDisplayNicknameInput();
    }
}
