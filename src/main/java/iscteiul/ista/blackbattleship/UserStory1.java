
package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
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
 * against a robot using a guest nickname.
 */
public class UserStory1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    private WebElement robotModeButton;

    @FindBy(css = ".input-xl")
    private WebElement nicknameInput;

    @FindBy(css = ".p-3 > .btn")
    private WebElement continueButton;

    /**
     * Initializes the page elements and explicit wait.
     *
     * @param driver WebDriver used to interact with the browser
     */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the Battleship game page.
     */
    public void openGamePage() {
        driver.get("https://papergames.io/pt-br/batalha-naval");
        driver.manage().window().setSize(
                new org.openqa.selenium.Dimension(1288, 697));
    }

    /**
     * Accepts the consent dialog if it is displayed.
     */
    public void acceptConsentIfPresent() {
        By consentSelector = By.cssSelector(
                "button.fc-button.fc-cta-consent");

        if (!driver.findElements(consentSelector).isEmpty()) {
            WebElement button = driver.findElement(consentSelector);

            if (button.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            }
        }
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
     * Returns the current browser URL.
     *
     * @return current page URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
