
package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object representing the Battleship game page.
 * Contains the elements and operations needed to start a game
 * against a robot and send an emoji during the match.
 */
public class UserStory4Selenide {

    static {
        Configuration.browserSize = "815x703";
    }

    private final SelenideElement consentButton =
            $("button.fc-button.fc-cta-consent");

    private final SelenideElement robotModeButton =
            $(".w-100:nth-child(2) > .btn .flex-grow-1");

    private final SelenideElement nicknameInput =
            $(".input-xl");

    private final SelenideElement continueButton =
            $(".p-3 > .btn");

    private final SelenideElement emojiMenuButton =
            $("button:has(img.emoji-icon)");

    private final SelenideElement selectedEmojiButton =
            $("button:has(img[src='assets/images/emoji/1f60e.png'])");

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

    public void openEmojiMenu() {
        emojiMenuButton.shouldBe(visible).click();
    }

    public void sendEmoji() {
        selectedEmojiButton.shouldBe(visible).click();
    }

    public String getCurrentUrl() {
        return com.codeborne.selenide.WebDriverRunner.url();
    }
}
