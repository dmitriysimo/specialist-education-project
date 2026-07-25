package fourth_lesson;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ParametrizedCSVTest {

    String url = "https://slqamsk.github.io/cases/slflights/v01/";

    SelenideElement userNameInput = $("#username"),
            passwordInput = $("#password"),
            loginButton = $("#loginButton"),
            greetingBar = $("#greeting");
    ;

}
