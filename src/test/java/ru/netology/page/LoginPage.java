package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.UserInfo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");
    private final SelenideElement blockNotification = $("[data-test-id='error-notification'] .notification__block");


    public VerificationPage validData(UserInfo userInfo) {
        login(userInfo);
        return new VerificationPage();
    }

    public void login(UserInfo userInfo) {
        loginField.setValue(userInfo.getLogin());
        passwordField.setValue(userInfo.getPassword());
        loginButton.click();
    }

    public void invalidAuth() {

        errorNotification.shouldBe(visible);
    }

    public void cleanFields() {
        loginField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    }

    public void systemIsLocked() {
        blockNotification.shouldBe(visible);
    }
}
