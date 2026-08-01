package fourth_lesson.home_work.second_part;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Specialist {

    SpecialistPageObject page = new SpecialistPageObject();

    @Test
    void simple() {
        open("https://www.specialist.ru/ ");
        page.cookieConfirm.click();
    }
}
