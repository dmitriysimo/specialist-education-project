package credit_calculator;

import java.math.BigDecimal;

public class CalculationParameters {

    private double monthRate;

    public double getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(double monthRate) {
        this.monthRate = monthRate;
    }

    private BigDecimal growthFactor;

    public BigDecimal getGrowthFactor() {
        return growthFactor;
    }

    public void setGrowthFactor(BigDecimal growthFactor) {
        this.growthFactor = growthFactor;
    }

    private Double annuityCoefficient;

    public Double getAnnuityCoefficient() {
        return annuityCoefficient;
    }

    public void setAnnuityCoefficient(Double annuityCoefficient) {
        this.annuityCoefficient = annuityCoefficient;
    }

    private BigDecimal monthlyPayment;

    public BigDecimal getMonthlyPayment() {
        System.out.println("Размер ежемесячного платежа: " + monthlyPayment);
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
