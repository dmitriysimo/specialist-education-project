package second_lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import first_lesson_hw.BrowserConfigurator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class FreeCalculationTest extends BrowserConfigurator {

    @Test
    void positiveAuthorizationTest() {
        open("https://slqa.ru/cases/fc/v01");

        SelenideElement sumField = $(By.name("sum"));
        SelenideElement submitButton = $(By.name("submit"));
        ElementsCollection sumFields = $$(By.name("sum"));
        sumField.type("100");
        submitButton.click();
        submitButton.shouldBe(Condition.interactable).shouldBe(Condition.editable);
        System.out.println("Размер списка с именем 'sum'" + sumFields.size());
        System.out.println(sumField.getWrappedElement());
        clear();
        sumField.setValue("200");
        $(By.name("submit")).click();
        clear();
        sumField.sendKeys("300");
        $(By.name("submit")).click();
        clear();
    }

    private void clear() {
        sleep(2_000);
        $(By.name("sum")).clear();
    }
}
