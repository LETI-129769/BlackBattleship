
package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object representing the Battleship game page.
 * Contains the elements and operations needed to start a game
 * against a robot and fire at the opponent's board.
 */
public class UserStory3Selenide {

    static {
        Configuration.browserSize = "1200x900";
    }

    private final SelenideElement consentButton =
            $("button.fc-button.fc-cta-consent");

    private final SelenideElement robotModeButton =
            $(".w-100:nth-child(2) > .btn .flex-grow-1");

    private final SelenideElement nicknameInput =
            $(".input-xl");

    private final SelenideElement continueButton =
            $(".p-3 > .btn");

    private final SelenideElement opponentCell =
            $("[id^='board_ai-'] > tr:nth-child(2) > td.cell-1-8");

    public void openGamePage() {
        open("https://papergames.io/pt-br/batalha-naval");
    }

    public void acceptConsent() {
        consentButton.shouldBe(visible).click();
    }

    public void selectRobotMode() {
        robotModeButton.shouldBe(visible).click();
    }

    public void enterNickname(String nickname) {
        nicknameInput.shouldBe(visible).setValue(nickname);
    }

    public void confirmNickname() {
        continueButton.shouldBe(visible).click();
    }

    public void fireAtOpponent() {
        opponentCell.shouldBe(interactable).click();
    }
}
