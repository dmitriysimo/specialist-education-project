package credit_calculator;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class CreditCalculator {

    static CreditData data = new CreditData();
    static Scanner scanner = new Scanner(System.in);

    public static void userCalculate() {
        data = setCreditData();

    }

    /**
     * Метод ввода данных для кредита
     * @return объект CreditData с введенными данными
     */
    private static CreditData setCreditData() {
        if (data == null) {
            System.out.println("Введите сумму кредита:");
            data.setCreditSum(scanner.nextBigDecimal());
            System.out.println("Введите срок кредита:");
            data.setTerm(scanner.nextInt());
            System.out.println("Введите размер ставки:");
            data.setAnnualInterestRate(scanner.nextDouble());
        }
        return data;
    }

    private void calculateCreditData(CreditData data) throws InterruptedException {
        System.out.println("Выполняется расчет параметров кредита...");

        sleep(2000);



        System.out.println("Расчет завершен.");
    }
}
