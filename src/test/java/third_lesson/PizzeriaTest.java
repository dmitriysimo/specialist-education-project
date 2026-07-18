package third_lesson;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PizzeriaTest {
    @Test
    void test01AddPizzas() {
        open("https://slqamsk.github.io/cases/pizza/v08/");
        $x("//h3[contains(.,'Маргарита')]/../button")
                .shouldBe(exist)
                .shouldBe(visible)
                .click();
        $x("//div[contains(@class,'card') and contains(., 'Четыре сыра')]/button").click();
    }
}
