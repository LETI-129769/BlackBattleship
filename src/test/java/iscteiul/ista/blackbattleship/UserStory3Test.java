
package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory3.
 * Tests firing a missile at a position on the opponent's board.
 */
public class UserStory3Test {

    private WebDriver driver;
    private UserStory3 userStory3;

    /**
     * Initializes the browser and the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        userStory3 = new UserStory3(driver);
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
     * Tests firing at a position on the opponent's board.
     */
    @Test
    public void testFireAtOpponent() {
        userStory3.openGamePage();
        userStory3.acceptConsent();
        userStory3.selectRobotMode();
        userStory3.enterNickname("Player");
        userStory3.confirmNickname();
        userStory3.fireAtOpponent();

        assertTrue(driver.getCurrentUrl().contains("/pt-br/r/"),
                "The game room should be open.");
    }
}
