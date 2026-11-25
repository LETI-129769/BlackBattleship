
package testsuiteleti129769userstories1to4.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testsuiteleti129769userstories1to4.pages.UserStory1Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory1 using Selenide.
 * Tests the process of selecting robot mode, entering a nickname
 * and starting a Battleship game.
 */
public class UserStory1TestSelenide {

    private UserStory1Selenide userStory1;

    /**
     * Initializes the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        userStory1 = new UserStory1Selenide();
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Tests starting a game against a robot using the nickname Player.
     */
    @Test
    public void testChooseNicknameAndStartGame() {
        userStory1.openGamePage();
        userStory1.acceptConsentIfPresent();
        userStory1.selectRobotMode();
        userStory1.enterNickname("Player");
        userStory1.confirmNickname();

        webdriver().shouldHave(urlContaining("/pt-br/r/"));

        assertTrue(userStory1.getCurrentUrl().contains("/pt-br/r/"));
    }
}
