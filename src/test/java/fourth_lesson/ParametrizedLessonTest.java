package fourth_lesson;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class ParametrizedLessonTest {
    SelenideElement input = $("input[name='sum']"),
                    submitButton = $("input[type='submit']"),
                    result = $("h3"),
                    error = $("[name='error']"),
                    sum = $("span[name='sum']");

    String errorMessage = "Вы ввели не числовое значение.";

    @BeforeAll
    static void setup() {
        open("https://slqa.ru/cases/fc/v01/index.php");
    }

    @ParameterizedTest(name = "Мой тест, #{index}, для значения: {0}")
    @ValueSource(strings = {"100", "2000", "йцукен"})
    void setValueAndCalculate(String value) throws InterruptedException {
        input.setValue(value);
        submitButton.click();
        sleep(1000);
        Assertions.assertTrue(error.isDisplayed() ||sum.isDisplayed(), "Поле с информацией об ошибке или о результате расчета не отображается");
        Assertions.assertTrue(result.getText().contains(errorMessage)||sum.getText().contains(value));
    }
}
