package third_lesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
        open(url);
    }

    @Test
    void simpleCloseAlert() {
        simpleAlert.click();
        switchTo().alert().accept();
    }

    @Test
    void waitForAlert() {
        timerAlert.click();
        sleep(5_500);
        switchTo().alert().accept();
    }

    @Test
    void confirmAlertTest() {
        confirmAlert.click();
        switchTo().alert().accept();
        confirmAlert.click();
        switchTo().alert().dismiss();
    }

    @Test
    void promtAlertTest() {
        promptAlert.click();
        switchTo().alert().sendKeys("Dmitriy");
        switchTo().alert().accept();
        sleep(2_000);
    }

    @AfterEach
    void returnToDefault() {
        switchTo().defaultContent();
    }
}
