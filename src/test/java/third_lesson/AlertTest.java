package third_lesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AlertTest {

    static String url = "https://demoqa.com/alerts";
    SelenideElement simpleAlert = $("#alertButton");
    SelenideElement timerAlert = $("#timerAlertButton");
    SelenideElement confirmAlert = $("#confirmButton");
    SelenideElement promptAlert = $("#promtButton");

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        open(url);
    }

    @DisplayName("Простая проверка на закрытие алерта")
    @Test
    void simpleCloseAlert() {
        simpleAlert.click();
        switchTo().alert().accept();
    }

    @DisplayName("Проверка ожидания алерта")
    @Test
    void waitForAlert() {
        timerAlert.click();
        switchTo().alert().accept();
    }

    @DisplayName("Проверка алерта с подтверждением и отменой")
    @Test
    void confirmAlertTest() {
        confirmAlert.click();
        switchTo().alert().accept();
        confirmAlert.click();
        switchTo().alert().dismiss();
    }

    @DisplayName("Проверка алерта с вводом")
    @Test
    void promtAlertTest() {
        promptAlert.click();
        switchTo().alert().sendKeys("Dmitriy");
        switchTo().alert().accept();
        promptAlert.click();
        switchTo().alert().sendKeys("Dima");
        switchTo().alert().dismiss();
    }


    @AfterEach
    void returnToDefault() {
        switchTo().defaultContent();
    }
}
