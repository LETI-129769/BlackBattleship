
package testsuiteleti129769userstories1to4.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testsuiteleti129769userstories1to4.pages.UserStory4Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory4 using Selenide.
 * Tests sending an emoji during a Battleship match.
 */
public class UserStory4TestSelenide {

    private UserStory4Selenide userStory4;

    /**
     * Initializes the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        userStory4 = new UserStory4Selenide();
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Tests opening the emoji menu and sending the sunglasses emoji.
     */
    @Test
    public void testSendEmoji() {
        userStory4.openGamePage();
        userStory4.acceptConsent();
        userStory4.selectRobotMode();
        userStory4.enterNickname("Player");
        userStory4.confirmNickname();

        userStory4.openEmojiMenu();
        userStory4.sendEmoji();

        webdriver().shouldHave(urlContaining("/pt-br/r/"));

        assertTrue(userStory4.getCurrentUrl().contains("/pt-br/r/"),
                "The game room should remain open after sending the emoji.");
    }
}
