package credit_calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreditCalculator {

    static CreditData data = new CreditData();
    static Scanner scanner = new Scanner(System.in);
    static CalculatedParameters params = new CalculatedParameters();

    public static void main(String[] args) {
        userCalculate();
    }

    public static void userCalculate() {
        data = setCreditData();
        System.out.println("<<<<<<<<<>>>>>>>>" + data.getCreditSum());
        params = calculateCreditData(data);
        printCalculationResult(params);
    }

    /**
     * Метод ввода данных для кредита
     *
     * @return объект CreditData с введенными данными
     */
    private static CreditData setCreditData() {
        System.out.println("Введите сумму кредита:");
        data.setCreditSum(scanner.nextBigDecimal());
        System.out.println("Введите срок кредита:");
        data.setTerm(scanner.nextInt());
        System.out.println("Введите размер ставки:");
        data.setAnnualInterestRate(scanner.nextDouble());

        return data;
    }

    private static CalculatedParameters calculateCreditData(CreditData data) {
        System.out.println("Выполняется расчет параметров кредита...");

        params.setMonthlyRate(data.getAnnualInterestRate() / 1200);
        params.setGrowthFactor(BigDecimal.valueOf(Math.pow(1 + params.getMonthlyRate(), data.getTerm())));
        params.setAnnuityCoefficient(params.getMonthlyRate() * params.getGrowthFactor().doubleValue() / (params.getGrowthFactor().doubleValue() - 1));
        params.setMonthlyPayment(monthlyPaymentCalculator(data.getCreditSum(), params.getAnnuityCoefficient()));
        System.out.println("Ставка за месяц: " + params.getMonthlyRate() + "%");
        System.out.println("Множитель: " + params.getGrowthFactor());
        System.out.println("Коэфициент: " + params.getAnnuityCoefficient());

        System.out.println("Расчет завершен.");

        return params;
    }

    private static void printCalculationResult(CalculatedParameters params) {
        System.out.println("Результат расчета:  ");
        System.out.printf("Ежемесячная ставка: %.2f процентов %n", params.getMonthlyRate());
        System.out.printf("Ежемесячный платеж: %.2f руб.%n", params.getMonthlyPayment());
    }

    private static BigDecimal monthlyPaymentCalculator(BigDecimal value, Double growthFactor) {
        return value.multiply(new BigDecimal(growthFactor));
    }
}
