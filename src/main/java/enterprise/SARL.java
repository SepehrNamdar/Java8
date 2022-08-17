package enterprise;

public class SARL implements Company {

    @Override
    public double getTaxPercentage() {
        return DEFAULT_TAX_PERCENTAGE;
    }

}
