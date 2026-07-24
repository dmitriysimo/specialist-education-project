package third_lesson.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import third_lesson.homework.pages.MoneyTransferPO;

import java.util.ArrayList;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class AdditionalHomeWork {

    static final String url = "https://slqa.ru/cases/fc/v01/index.php";
    MoneyTransferPO transfer = new MoneyTransferPO();

    @BeforeAll
    static void openPage() {
        open(url);
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void calculationTest(int sum, int commission, int total) {
        System.out.println("Выполняется расчет коммисии для суммы " + sum + " рублей");

        transfer.setCalculationData(String.valueOf(sum));
        ArrayList<String> calculationData = transfer.getMoneyTransferData();

        Assertions.assertEquals(calculationData.get(0), String.valueOf(commission), "Расчетная комиссия не совпадает с ожидаемой");
        Assertions.assertEquals(calculationData.get(1), String.valueOf(total), "Общая сумма не совпадает с ожидаемой");
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(100, 10, 110),
                Arguments.of(2000, 20, 2020)
        );
    }

}
