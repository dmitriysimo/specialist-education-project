package second_lesson;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SecondLessonHomeWork {

    static final String url = "https://slqa.ru/cases/fc/v01/index.php";
    static Random random = new Random();
    String checkedText = " Общая сумма к оплате составит ";
    SelenideElement input = $("input[name='sum']");
    SelenideElement submitButton = $(By.name("submit"));
    SelenideElement calculationBanner = $("h3");

    @BeforeAll
    static void openPage() {
       open(url);
    }

    @ParameterizedTest
    @MethodSource("sumProvider")
    void calculationTest(int sum) {
        System.out.println("Выполняется расчет коммисии для суммы " + sum + " рублей");
        input.type(String.valueOf(sum));
        submitButton.click();

        calculationBanner.shouldBe(visible).shouldHave(text(checkedText));
        System.out.println("Баннер с расчетом появился и содержит верный текст");
    }

    static Stream<Integer> sumProvider() {
        return Stream.generate(() -> random.nextInt(901) + 100)
                                           .limit(5);
    }

    @AfterEach
    void tearDown() {
        sleep(2_000);
        input.clear();
    }
}
