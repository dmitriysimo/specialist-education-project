package third_lesson.homework;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import third_lesson.homework.pages.LoginPO;

import static com.codeborne.selenide.Selenide.*;
import static third_lesson.homework.Consts.*;

public class StandardHomeWork {

    LoginPO loginPage = new LoginPO();

    @DisplayName("Проверка авторизации для заблокированного пользователя")
    @Test
    void wrongLoginTest() {
        open(LOGIN_URL);
        loginPage.setCredentialsAndEnter(USERNAME, PASSWORD);

        Assertions.assertTrue(loginPage.checkErrorMessage(BLOCKED_MESSAGE));
    }

    @Test
    void checkSimpleForm() {
        open(SIMPLE_FORM_URL);

        Assertions.assertTrue($$(".not_unique_class").findBy(Condition.text(FORM_TEXT)).isDisplayed(), "Искомая форма не найдена");
    }
}
