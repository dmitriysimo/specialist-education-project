package third_lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dmitry Sim
 * Класс пейдж объекта для страницы расчета комиссии
 */
public class MoneyTransferPO {

    ArrayList<String> calculatedValues = new ArrayList<>();

    SelenideElement input = $("input[name='sum']"),
                    submitButton = $(By.name("submit")),
                    comFiled   = $("span[name='com']"),
                    totalFiled   = $("span[name='total']");

    public void setCalculationData(String value) {
        input.setValue(value);
        submitButton.click();
    }

    public ArrayList <String> getMoneyTransferData() {
        System.out.println("Рассчитанное значение комиссии: " + comFiled.getText());
        calculatedValues.add(comFiled.getText());
        System.out.println("Рассчитанное значение общей суммы: " + totalFiled.getText());
        calculatedValues.add(totalFiled.getText());

        return calculatedValues;
    }
}
