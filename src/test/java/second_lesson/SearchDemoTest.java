package second_lesson;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchDemoTest {
    @Test
    public void testElementSearchMethods() {
        open("https://slqamsk.github.io/demo/search-demo/");

        By myLocator = By.id("submit-button");
        SelenideElement myElement = Selenide.element(myLocator);
        myElement.shouldBe(visible);

        element(By.id("submit-button")).shouldBe(visible);
        $(By.id("submit-button")).shouldBe(visible);

        $(By.name("interests")).shouldBe(visible);
        $(By.className("nav-link")).shouldBe(visible);
        $(By.tagName("input")).shouldBe(visible);
        $(By.linkText("Контакты и обратная связь")).shouldBe(visible);
        $(By.partialLinkText("длинный")).shouldBe(visible);

        // По id
        $(By.id("submit-button")).shouldBe(visible);
        $("#submit-button").shouldBe(visible);

        // По имени тега
        $(By.tagName("input")).shouldBe(visible);
        $("input").shouldBe(visible);

        // По имени класса
        $(By.className("nav-link")).shouldBe(visible);
        $(".nav-link").shouldBe(visible);

        // По имени (атрибуту name)
        $(By.name("interests")).shouldBe(visible);
        $("[name=interests]").shouldBe(visible);

        // По любому атрибуту
        $("[data-testid=123]");
        $("[data-testid='123']");
    }
}
