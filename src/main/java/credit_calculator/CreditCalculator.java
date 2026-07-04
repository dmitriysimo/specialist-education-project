package credit_calculator;

import java.util.Scanner;

public class CreditCalculator {

    CreditData data = new CreditData();
    Scanner scanner = new Scanner(System.in);

    void userCalculate() {
        data = setCreditData();

    }

    /**
     * Метод ввода данных для кредита
     * @return объект CreditData с введенными данными
     */
    private CreditData setCreditData() {
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

    private void calculateCreditData(){

    }
}
