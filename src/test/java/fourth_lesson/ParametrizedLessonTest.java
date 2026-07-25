package fourth_lesson;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedLessonTest {
    SelenideElement input = $("input[name='sum']"),
                    submitButton = $("input[type='submit']"),
                    result = $("h3"),
                    sum = $("span[name='sum']");

    String errorMessage = "Вы ввели не числовое значение.";

    @BeforeAll
    static void setup() {
        open("https://slqa.ru/cases/fc/v01/index.php");
    }

    @ParameterizedTest(name = "Мой тест, #{index}, для значения: {0}")
    @ValueSource(strings = {"100", "2000", "йцукен"})
    void setValueAndCalculate(String value) {
        input.setValue(value);
        submitButton.click();
        Assertions.assertTrue(result.getText().contains(errorMessage)||sum.getText().contains(value));
    }
}
