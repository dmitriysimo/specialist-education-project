package third_lesson.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import third_lesson.homework.pages.CreditCalcPO;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class CreditCalcTest {

    CreditCalcPO mainPage = new CreditCalcPO();

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/cases/loan-calc/v01/");
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void simpleCalcCheck(double sum, int term, double rate, boolean type) {
        mainPage.setValues(sum, term, rate, type);

    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(10000.0, 10, 15.0, true),
                Arguments.of(200000.0, 24, 12.25, false)
        );
    }
}
