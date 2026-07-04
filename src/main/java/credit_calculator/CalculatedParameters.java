package credit_calculator;

import java.math.BigDecimal;

public class CalculatedParameters {

    /**
     * Ежемесячкная ставка
     */
    private double monthlyRate;

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    /**
     * Множитель наращения процента
     */
    private BigDecimal growthFactor;

    public BigDecimal getGrowthFactor() {
        return growthFactor;
    }

    public void setGrowthFactor(BigDecimal growthFactor) {
        this.growthFactor = growthFactor;
    }

    /**
     * Коэффициент аннуитета
     */
    private Double annuityCoefficient;

    public Double getAnnuityCoefficient() {
        return annuityCoefficient;
    }

    public void setAnnuityCoefficient(Double annuityCoefficient) {
        this.annuityCoefficient = annuityCoefficient;
    }

    /**
     * Ежемесячный платеж
     */
    private BigDecimal monthlyPayment;

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
