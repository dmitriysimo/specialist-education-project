package credit_calculator;

import java.math.BigDecimal;

public class CreditData {
    /**
     * Сумма кредита
     */
    private BigDecimal creditSum;

    public BigDecimal getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(BigDecimal creditSum) {
        this.creditSum = creditSum;
    }

    /**
     * Кредитная ставка в процентах
     */
    private Double annualInterestRate;

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Срок кредитования
     */
    private int term;

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }




}
