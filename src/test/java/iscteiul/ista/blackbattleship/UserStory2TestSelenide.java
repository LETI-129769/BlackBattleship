
package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
