package third_lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalculatedPO {

    SelenideElement resultAmount = $("#result-amount"),
                    resultTerm = $("#result-term"),
                    resultRate = $("#result-rate"),
                    resultType= $("#result-payment-type"),
                    resultMonthly = $("#result-monthly"),
                    overpayment = $("#overpayment"),
                    resultTotal = $("#total-payment"),
                    scheduleButton = $("#show-schedule-btn"),
                    newCalcButton = $("#new-calculation-btn"),
                    header = $("h2");
}
