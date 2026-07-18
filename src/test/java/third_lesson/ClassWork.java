package third_lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ClassWork {

    static ElementsCollection cards = $$(".card");
    SelenideElement margoButton  = cards.findBy(Condition.text("Маргарита"));
    SelenideElement fourCheeseButton = cards.findBy(Condition.text("Четыре сыра"));
    SelenideElement cartButton = $(".cart-link");
    ElementsCollection itemsInCart = $$(".cart-item");

    @BeforeAll
    static void setUp() {
        open("https://slqamsk.github.io/cases/pizza/v08/");
    }

    @Test
    void selectPizzaSet() {
        margoButton.shouldBe(visible);
        fourCheeseButton.shouldBe(visible);

        margoButton.$("button").click();
        fourCheeseButton.$("button").click();

        cartButton.click();
        List<String> itemsNames = new ArrayList<>();
        for (SelenideElement item : itemsInCart) {
            itemsNames.add((item.text()));
        }
        System.out.println("Наименование товаров в корзине: " + itemsNames);

        boolean hasMargo = itemsNames.stream().anyMatch(name -> name.contains("Маргарита"));
        boolean hasFourCheese = itemsNames.stream().anyMatch(name -> name.contains("Четыре сыра"));

        Assertions.assertTrue(hasMargo&&hasFourCheese);
    }

}
