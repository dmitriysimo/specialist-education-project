package first_lesson_hw.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static first_lesson_hw.consts.Const.URLS.START_PAGE;

public class AuthorizationPage {

    private final SelenideElement loginField = $("#user-name"),
                                  passwordField = $("#password"),
                                  loginButton = $("#login-button"),
                                  errorBanner = $("[data-test='error']"),
                                  itemContainer = $("#header_container");

    /**
     * Метод ввобда данных авторизации
     * @param login - логин пользователя
     * @param password - пароль пользователя
     */
    public void login(String login, String password) {
         loginField.setValue(login);
         passwordField.setValue(password);
         loginButton.click();
    }

    public boolean rightAuthCheck() {
        itemContainer.shouldBe(Condition.visible, Duration.ofSeconds(5));
        String currentUrl = driver().getCurrentFrameUrl();

        return currentUrl.equals(START_PAGE);
    }

    public boolean wrongAuthCheck() {
        return errorBanner.isDisplayed();
    }
}
