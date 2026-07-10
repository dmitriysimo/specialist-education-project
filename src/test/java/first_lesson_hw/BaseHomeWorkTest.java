package first_lesson_hw;

import first_lesson_hw.pages.AuthorizationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static first_lesson_hw.consts.Const.Credentials.*;
import static first_lesson_hw.consts.Const.URLS.LOGIN_URL;

public class BaseHomeWorkTest extends BrowserConfigurator{

    AuthorizationPage authorization = new AuthorizationPage();

    @BeforeEach
    void settingUp() {
        open(LOGIN_URL);
    }

    @Test
    void positiveAuthorizationTest() {
        authorization.login(VALID_LOGIN, VALID_PASSWORD);

        Assertions.assertTrue(authorization.rightAuthCheck());
    }

    @Test
    void wrongLoginAuthorizationTest() {
        authorization.login(INVALID_LOGIN, VALID_PASSWORD);

        Assertions.assertTrue(authorization.wrongAuthCheck());
    }

    @Test
    void wrongPasswordAuthorizationTest() {
        authorization.login(VALID_LOGIN, INVALID_PASSWORD);

        Assertions.assertTrue(authorization.wrongAuthCheck());
    }

    @AfterEach
    void tearDown() {
        refresh();
    }
}
