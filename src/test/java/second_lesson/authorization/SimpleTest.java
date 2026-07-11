package second_lesson.authorization;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    final String login = "standard_user";
    final String password = "stand_pass1";
    final String wrongPassword = "stand_pass2";
    final String userName = "Иванов Иван Иванович";
    static final String url = "https://slqamsk.github.io/cases/slflights/v01/";
    final String errorMessage = "Неверное имя пользователя или пароль";
    static SelenideElement loginInput;
    static SelenideElement passwordInput;
    static SelenideElement loginButton;


    @BeforeAll
    static void setUp(){
        open(url);

        loginInput =  $("#username");
        passwordInput = $("#password");
        loginButton = $("#loginButton");
    }

    @Test
    void test01LoginSuccess() {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        loginButton.click();

        assertTrue(loginCheck(), "Вход не выполнен");
    }

    @Test
    void test02WrongLoginWrongPassword() {
        loginInput.setValue(login);
        passwordInput.setValue(wrongPassword);
        loginButton.click();

        assertTrue(errorCheck(), "Вход выполнен с неверным паролем/логином");
    }

    boolean loginCheck(){
        sleep(3_000);
        SelenideElement greetingBar =  $("#greeting");

        return greetingBar.isDisplayed()&&greetingBar.getText().contains(userName);
    }

    boolean errorCheck(){
        sleep(3_000);
        SelenideElement errorBanner =  $("#message");
        System.out.println("123123123"+errorBanner.is(visible));
        System.out.println(errorBanner.getText().contains(errorMessage));

        return errorBanner.is(visible)&&errorBanner.getText().contains(errorMessage);
    }

    @Test
    void formTest() {
        loginInput.shouldBe(visible).shouldBe(editable).shouldBe(enabled);
        passwordInput.shouldBe(visible).shouldBe(editable).shouldBe(enabled);
        loginButton.shouldBe(visible).shouldBe(enabled);
    }

    @AfterEach
    void reset() {
        refresh();
    }
}
