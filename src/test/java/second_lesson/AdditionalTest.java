package second_lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static second_lesson.Consts.Dataset.URL;
import static second_lesson.Consts.TestValues.*;
import static second_lesson.Consts.TestValues.CITY_AVAILABILITY;

/**
 * Позитивный тест формы фильтрации на сайте "Мира Охоты"
 */
public class AdditionalTest {

    static SelenideElement brand;
    static SelenideElement caliber;
    static SelenideElement bulletType;
    static SelenideElement bulletWeight;
    static SelenideElement huntObject;
    static SelenideElement cityAvailability;
    ElementsCollection cards = $$(".card-container");
    SelenideElement showButton = $(".filter-commands");
    Random random = new Random();

    /**
     * Подготовка тестовых данных и окружения
     */
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        open(URL);
        brand = getInput("Бренд");
        caliber = getInput("Калибр");
        bulletType = getInput("Тип пули");
        bulletWeight = getInput("Масса пули");
        huntObject = getInput("Объект охоты");
        cityAvailability = getInput("Наличие в магазинах");
    }

    @DisplayName("Проверка заполнения формы поиска патронов")
    @Test
    void checkHuntForm() {
        brand.shouldBe(Condition.visible);
        caliber.shouldBe(Condition.visible);
        bulletType.shouldBe(Condition.visible);
        bulletWeight.shouldBe(Condition.visible);
        huntObject.shouldBe(Condition.visible);
        cityAvailability.shouldBe(Condition.visible);

        setValueAndChooseCheckbox(brand, BRAND);
        setValueAndChooseCheckbox(caliber, CALIBER);
        setValueAndChooseCheckbox(bulletType, BULLET_TYPE);
        setValueAndChooseCheckbox(bulletWeight, BULLET_WEIGHT);
        setValueAndChooseCheckbox(huntObject, HUNT_OBJECT);
        setValueAndChooseCheckbox(cityAvailability, CITY_AVAILABILITY);

        showButton.click();

        cards.get(random.nextInt(1)).shouldHave(Condition.text("308"));
    }

    /**
     * Метод опрееления поля ввода данных
     * @param fieldName - имя поля
     * @return - поле ввода
     */
    static SelenideElement getInput(String fieldName) {
        return $$(".filter-property__caption-name")
                .findBy(Condition.text(fieldName))
                .parent()
                .parent()
                .$(".filter-property__search")
                .$("input");
    }

    /**
     * Метод ввода значения в поле поиска
     * @param input - элемент поиска
     * @param value - значение
     */
    void setValueAndChooseCheckbox (SelenideElement input, String value) {
        input.click();
        input.setValue(value);
        input.parent().parent().$(".filter-value").click();
    }
}
