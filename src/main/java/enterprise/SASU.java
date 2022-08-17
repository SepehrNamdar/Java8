package enterprise;

public class SASU implements Company {

    @Override
    public double getTaxPercentage() {
        return DEFAULT_TAX_PERCENTAGE;
    }

}
