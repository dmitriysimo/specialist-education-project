package fourth_lesson;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedCSVTest {

    static final String url = "https://slqamsk.github.io/cases/slflights/v01/";

    SelenideElement userNameInput = $("#username"),
                    passwordInput = $("#password"),
                    loginButton = $("#loginButton"),
                    greeting = $("#greeting"),
                    logout = $("#logoutButton"),
                    searchFlight = $("[onclick='findFlights()']"),
                    registerButton = $(".register-btn"),
                    passengerName=$("#passengerName"),
                    passportNumber = $("#passportNumber"),
                    passengerEmail = $("#email"),
                    phoneNumber = $("#phoneNumber"),
                    departureButton = $("#departureCity"),
                    arrivedButton = $("#arrivalCity");



    @BeforeAll
    static void setup() {
        open(url);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "credentials.csv", numLinesToSkip = 1)
    void simpleCheck(String username, String password, String initials) {
        setCredentialsAndLogin(username, password);
        logout.shouldBe(visible).shouldBe(interactable);
        greeting.shouldHave(text("Добро пожаловать, " + initials + "!"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "credentials_advanced.csv", numLinesToSkip = 1)
    void advancedCheck(String username, String password, String name, String phone, String email, String passport) {
        setCredentialsAndLogin(username, password);

        departureButton.selectOptionContainingText("Казань");

        arrivedButton.selectOptionContainingText("Нью-Йорк");
        searchFlight.click();

        registerButton.click();

        passengerName.shouldHave(text(name));
        passportNumber.shouldHave(text(passport));
        passengerEmail.shouldHave(text(email));
        phoneNumber.shouldHave(text(phone));

    }

    void setCredentialsAndLogin(String username, String password) {
        userNameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    @AfterEach
    void logout()
    {
        logout.click();
    }
}
