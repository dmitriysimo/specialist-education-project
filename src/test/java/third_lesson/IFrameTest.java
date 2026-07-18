package third_lesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class IFrameTest {

    String url = "https://demoqa.com/frames";

    @BeforeEach
    void setUp() {
        Configuration.browserSize="1920x1080";
        open(url);
    }

    @Test
    void switchToFrameTest() {

        for (int i = 1; i == $$("frame").size(); i++) {
            String frame = "frame" + i;
            switchTo().frame($("iframe[id='"+frame+"']"));
            System.out.println("Фрейм " + i + " обнаружен");
            $("h1").shouldHave(text("This is a sample page"));
            switchTo().defaultContent();
        }
    }

    @Test
    void simpleTest() {
        switchTo().frame(0);
        $("h1").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
        switchTo().frame(1);
        $("h1").shouldHave(text("This is a sample page"));
    }
}
