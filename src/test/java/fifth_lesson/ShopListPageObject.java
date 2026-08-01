package fifth_lesson;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ShopListPageObject {

    public ShopListPageObject() {

    }

    private final ElementsCollection primaryButtons = $$(".primary"),
                                     products = $$("li");

    private final SelenideElement navigateMenu = $("#main-menu"),
                                  addNewItemButton = primaryButtons.findBy(text("Добавить новый продукт")),
                                  itemNameInput = $("#product-name"),
                                  newItemSaveButton = $("#save-product"),
                                  errorBar = $("#error-log");

    /**
     * Метод для перехода на страницу списка покупок
     * @param url - адрес страницы
     */
    public void openStartPage(String url) {
        open(url);
    }

    /**
     * Метод проверки наличия добавленного товара в списке доступных товаров
     * @param itemName - название товара
     */
    public void checkNewItemAdding(String itemName) {
        navigateToSection("products.html");

        products.findBy(text(itemName)).shouldBe(visible);
    }

    /**
     * Метод валидации поля с названием товара
     *
     * @param itemName - название товара
     */
    public void validateItemName(String itemName) {
        step("Проверка валидации поля с названием товара", () -> {
        addNewItem(itemName, true);
        errorBar.shouldBe(visible);
        });
    }

    /**
     * Метод получения значения поля с ошибкой
     * @return - текст ошибки
     */
    public String getErrorMessage() {
        return errorBar.getText();
    }

    /**
     * Метод добавления нового продукта в список покупок
     * @param itemName - название продукта
     * @param path - способ навигации к странице добавления товара
     */
    public void addNewItem(String itemName, boolean path) {
        step("Добавление нового продукта в список", () -> {
            if (path) {
                navigateToSection("products.html");
                addNewItemButton.shouldBe(visible).click();
            } else {
                navigateToSection("add-product.html");
            }

            itemNameInput.setValue(itemName);
            newItemSaveButton.shouldBe(clickable).click();
        });
    }

    /**
     * Метод изменения названия товара
     * @param itemName - старое название товара
     * @param newItemName - новое название товара
     */
    public void editItem(String itemName, String newItemName) {
        editing(itemName, newItemName);

        navigateToSection("products.html");

    }

    /**
     * Метод проверки появления товара в списке товаров
     * @param itemName - имя искомого товара
     * @return - результат поиска
     */
    public boolean isItemPresent(String itemName) {
        return products.findBy(text(itemName)).is(visible);
    }

    /**
     * Метод открытия раздела по имени раздела
     * @param sectionName - имя раздела
     */
    private void navigateToSection(String sectionName) {
        navigateMenu.$("a[href='" + sectionName + "']").click();
    }

    /**
     * Метод открытия раздела редактирования
     * @param itemName - название товара
     * @param newItemName - название раздела
     */
    private void editing(String itemName, String newItemName) {
        products.findBy(text(itemName)).$(".edit-product").shouldBe(visible).click();
        itemNameInput.shouldBe(editable).shouldBe(visible);

        itemNameInput.setValue(newItemName);
        newItemSaveButton.shouldBe(clickable).click();
    }
}
