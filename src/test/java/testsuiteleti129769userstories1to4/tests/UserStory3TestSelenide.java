
package testsuiteleti129769userstories1to4.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testsuiteleti129769userstories1to4.pages.UserStory3Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

/**
 * Test class for UserStory3 using Selenide.
 * Tests firing a missile at a position on the opponent's board.
 */
public class UserStory3TestSelenide {

    private UserStory3Selenide userStory3;

    @BeforeEach
    public void setUp() {
        userStory3 = new UserStory3Selenide();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void testFireAtOpponent() {
        userStory3.openGamePage();
        userStory3.acceptConsent();
        userStory3.selectRobotMode();
        userStory3.enterNickname("Player");
        userStory3.confirmNickname();
        userStory3.fireAtOpponent();

        webdriver().shouldHave(urlContaining("/pt-br/r/"));
    }
}
