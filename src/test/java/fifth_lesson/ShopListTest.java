package fifth_lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;

public class ShopListTest {

    private final static String url = "https://slqamsk.github.io/apps/ShopList/v07/";
    static ShopListPageObject page = new ShopListPageObject();

    @BeforeAll
    static void setUp() {
        page.openStartPage(url);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "new items.csv", numLinesToSkip = 1)
    void positiveCheckNewItemCreate(String name, Boolean isNavigate) {
        page.addNewItem(name, isNavigate);
        page.checkNewItemAdding(name);

        step("Проверка наличия товара в списке доступных товаров", () ->
            Assertions.assertTrue(page.isItemPresent(name), "Товар не найден")
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "wrong items.csv", numLinesToSkip = 1)
    void negativeCheckNewItemCreate(String name, String errorText) {
        page.validateItemName(name);

        step("Проверка отображения ошибки " + errorText, () ->
        Assertions.assertTrue(page.getErrorMessage().contains(errorText), "Сообщение об ошибке не соответствует ожидаемому"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "edited item names.csv", numLinesToSkip = 1)
    void editCheckNewItemCreate(String name, String newName) {
        page.addNewItem(name, true);
        step("Изменение названия товара на новое ", () ->
        page.editItem(name, newName)
        );

        step("Проверка нового названия", () ->
            Assertions.assertTrue(page.isItemPresent(newName), "Товар не найден")
        );
    }

}
