package fourth_lesson.home_work.second_part;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SpecialistPageObject {

    SpecialistPageObject() {}

    SelenideElement cookieConfirm = $("#cookieConsent__ok"),
            learningFormatsButton = $("a[href='/learning-formats']"),
            freeFormatButton = $("a[href='/free-learning-new']"),
            directionButton = $("#Filter_CategoriesDirectionFilter");
}
