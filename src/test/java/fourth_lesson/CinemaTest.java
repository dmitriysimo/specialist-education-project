package fourth_lesson;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CinemaTest {

    @ParameterizedTest
    @CsvFileSource(resources = "cinema_data.csv", numLinesToSkip = 1)
    void test01CinemaParametrizedPositive(String age, String date, String session, String film, String price) {
        open("https://slqamsk.github.io/cases/cinema/v02");
        $("input[name=age]").setValue(age);
        //String dateValue = "28.07.2026"; // Дата в формате YYYY-MM-DD
        $("input[name='date']").setValue(date);
        $x("//input[@name='session' and @value=" + session + "]").click();
        $("input[name=film][value='" + film + "']").click();
        $x("//button[@type='submit']").click();
        $x("//div[@id='result']").shouldHave(text("Стоимость билета: " + price + " рублей."));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "cinema_data_negative.csv", numLinesToSkip = 1)
    void test02CinemaParametrizedNegative(String age, String date, String session, String film) {
        open("https://slqamsk.github.io/cases/cinema/v02");
        $("input[name=age]").setValue(age);
        //String dateValue = "28.07.2026"; // Дата в формате YYYY-MM-DD
        $("input[name='date']").setValue(date);
        $x("//input[@name='session' and @value=" + session + "]").click();
        $("input[name=film][value='" + film + "']").click();
        $x("//button[@type='submit']").click();
        $x("//div[@id='result']").shouldHave(text("Возраст не подходит для просмотра этого фильма."));
    }

}
