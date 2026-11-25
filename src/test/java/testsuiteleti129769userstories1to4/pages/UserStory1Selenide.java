
package testsuiteleti129769userstories1to4.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object representing the Battleship game page.
 * Contains the elements and operations needed to start a game
 * against a robot using a guest nickname.
 */
public class UserStory1Selenide {

    private final SelenideElement robotModeButton =
            $(".w-100:nth-child(2) > .btn .flex-grow-1");

    private final SelenideElement nicknameInput =
            $(".input-xl");

    private final SelenideElement continueButton =
            $(".p-3 > .btn");

    /**
     * Opens the Battleship game page.
     */
    public void openGamePage() {
        Configuration.browserSize = "1288x697";
        open("https://papergames.io/pt-br/batalha-naval");
    }

    /**
     * Accepts the consent dialog if it is displayed.
     */
    public void acceptConsentIfPresent() {
        SelenideElement consentButton =
                $("button.fc-button.fc-cta-consent");

        if (consentButton.exists() && consentButton.isDisplayed()) {
            consentButton.shouldBe(visible).click();
        }
    }

    /**
     * Selects the game mode against a robot.
     */
    public void selectRobotMode() {
        robotModeButton.shouldBe(visible).click();
    }

    /**
     * Enters the guest nickname.
     *
     * @param nickname nickname to use in the game
     */
    public void enterNickname(String nickname) {
        nicknameInput.shouldBe(visible).setValue(nickname);
    }

    /**
     * Confirms the nickname and proceeds to the game.
     */
    public void confirmNickname() {
        continueButton.shouldBe(visible).click();
    }

    /**
     * Returns the current browser URL.
     *
     * @return current page URL
     */
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
