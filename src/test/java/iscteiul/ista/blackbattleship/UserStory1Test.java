
package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for UserStory1.
 * Tests the process of selecting robot mode, entering a nickname
 * and starting a Battleship game.
 */
public class UserStory1Test {

    private WebDriver driver;
    private UserStory1 userStory1;

    /**
     * Initializes the browser and the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        userStory1 = new UserStory1(driver);
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
     * Tests starting a game against a robot using the nickname Player.
     */
    @Test
    public void testChooseNicknameAndStartGame() {
        userStory1.openGamePage();
        userStory1.acceptConsentIfPresent();
        userStory1.selectRobotMode();
        userStory1.enterNickname("Player");
        userStory1.confirmNickname();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(d -> d.getCurrentUrl().contains("/pt-br/r/"));

        assertTrue(userStory1.getCurrentUrl().contains("/pt-br/r/"));
    }
}
