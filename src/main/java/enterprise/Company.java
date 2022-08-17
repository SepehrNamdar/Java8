package enterprise;

public interface Company {

    double DEFAULT_TAX_PERCENTAGE = 0.1;

    default double calculateTax(double annualTurnover) {
        return annualTurnover * getTaxPercentage();
    }

    double getTaxPercentage();

}
