
package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object representing the Battleship game page.
 * Contains the elements and operations needed to select
 * the game mode against a robot.
 */
public class UserStory2Selenide {

    private final SelenideElement robotModeButton =
            $(".w-100:nth-child(2) > .btn .flex-grow-1");

    private final SelenideElement nicknameInput =
            $(".input-xl");

    public void openGamePage() {
        open("https://papergames.io/pt-br/batalha-naval");
    }

    public void acceptConsentIfPresent() {
        SelenideElement consentButton =
                $("button.fc-button.fc-cta-consent");

        if (consentButton.exists() && consentButton.isDisplayed()) {
            consentButton.shouldBe(visible).click();
        }
    }

    public void selectRobotMode() {
        robotModeButton.shouldBe(visible).click();
    }

    public void shouldDisplayNicknameInput() {
        nicknameInput.shouldBe(visible);
    }
}
