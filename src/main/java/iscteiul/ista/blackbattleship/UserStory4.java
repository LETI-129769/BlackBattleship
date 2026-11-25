
package iscteiul.ista.blackbattleship;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object representing the Battleship game page.
 * Contains the elements and operations needed to start a game
 * against a robot and send an emoji during the match.
 */
public class UserStory4 {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "button.fc-button.fc-cta-consent")
    private WebElement consentButton;

    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    private WebElement robotModeButton;

    @FindBy(css = ".input-xl")
    private WebElement nicknameInput;

    @FindBy(css = ".p-3 > .btn")
    private WebElement continueButton;

    @FindBy(css = "button:has(img.emoji-icon)")
    private WebElement emojiMenuButton;

    @FindBy(css = "button:has(img[src='assets/images/emoji/1f60e.png'])")
    private WebElement selectedEmojiButton;

    /**
     * Initializes the page elements and explicit wait.
     *
     * @param driver WebDriver used to interact with the browser
     */
    public UserStory4(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the Battleship game page and sets the browser window size.
     */
    public void openGamePage() {
        driver.get("https://papergames.io/pt-br/batalha-naval");
        driver.manage().window().setSize(new Dimension(815, 703));
    }

    /**
     * Accepts the consent dialog.
     */
    public void acceptConsent() {
        wait.until(ExpectedConditions.elementToBeClickable(consentButton)).click();
    }

    /**
     * Selects the game mode against a robot.
     */
    public void selectRobotMode() {
        wait.until(ExpectedConditions.elementToBeClickable(robotModeButton)).click();
    }

    /**
     * Enters the guest nickname.
     *
     * @param nickname nickname to use in the game
     */
    public void enterNickname(String nickname) {
        wait.until(ExpectedConditions.visibilityOf(nicknameInput)).sendKeys(nickname);
    }

    /**
     * Confirms the nickname and proceeds to the game.
     */
    public void confirmNickname() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    /**
     * Opens the emoji menu during the match.
     */
    public void openEmojiMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(emojiMenuButton)).click();
    }

    /**
     * Selects and sends the sunglasses emoji.
     */
    public void sendEmoji() {
        wait.until(ExpectedConditions.elementToBeClickable(selectedEmojiButton)).click();
    }
}
