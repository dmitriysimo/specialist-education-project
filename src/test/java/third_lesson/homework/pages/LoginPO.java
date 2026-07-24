package third_lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Dmitry Sim
 * Класс пейдж объекта для страницы авторизации
 */
public class LoginPO {

    private final SelenideElement loginInput = $("#username"),
                                  passwordInput = $("#password"),
                                  loginButton = $("#loginButton"),
                                  errorMessage = $("#message");


    public void setCredentialsAndEnter(String login, String password) {
        loginInput.shouldBe(visible).setValue(login).pressEnter();
        passwordInput.shouldBe(visible).setValue(password).pressEnter();
        loginButton.click();
    }

    public Boolean checkErrorMessage(String messageText) {
        System.out.println("Сравниваемые сообщения: " + messageText + " и " + errorMessage.getText());

        return errorMessage.shouldBe(visible, Duration.ofSeconds(3)).getText().equals(messageText);
    }

}
