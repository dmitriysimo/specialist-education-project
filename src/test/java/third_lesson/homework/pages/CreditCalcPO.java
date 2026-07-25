package third_lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreditCalcPO {

    SelenideElement sumInput = $("#amount"),
                    termInput    = $("#term"),
                    rateInout = $("#rate"),
                    annuityRadio = $("input[value='annuity']"),
                    diffRadio = $("input[value='diff']"),
                    calcButton = $("#calculate-btn"),
                    clearButton = $("#clear-btn");


    public void setValues(double sum, int term, double rate, boolean type) {
        sumInput.setValue(String.valueOf(sum));
        termInput.setValue(String.valueOf(term));
        rateInout.setValue(String.valueOf(rate));
        if (type) {
            annuityRadio.click();
        } else {
            diffRadio.click();
        }
        calcButton.click();
    }



}
