
package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory4.
 * Tests sending an emoji during a Battleship match.
 */
public class UserStory4Test {

    private WebDriver driver;
    private UserStory4 userStory4;

    /**
     * Initializes the browser and the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        userStory4 = new UserStory4(driver);
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

        assertTrue(driver.getCurrentUrl().contains("/pt-br/r/"),
                "The game room should remain open after sending the emoji.");
    }
}
