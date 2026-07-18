package third_lesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicWaitTest {

    String url = "https://slqa.ru/cases/WaitsSimpleForm/";
    SelenideElement timeInput = $("#duration_time");
    SelenideElement setButton = $("#show_element");
    int time = 10;
    SelenideElement dynamicBanner = $("#dynamic_content");

    @BeforeAll
    static void basic() {
        Configuration.timeout = 12000;
    }

    @BeforeEach
    void setUp() {
        open(url);
    }

    @Test
    void setWaitingTimeAndCheck() {
        timeInput.setValue(String.valueOf(time));
        setButton.click();

        String bannerText = dynamicBanner.getText();

        Assertions.assertTrue(bannerText.contains(String.valueOf(time*1000)));
    }
}
