package enterprise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyShould {

    private static final int ANNUAL_TURNOVER = 1000;

    @Test
    void default_tax_percentage_is_10_percent() {
        assertThat(Company.DEFAULT_TAX_PERCENTAGE).isEqualTo(0.1);
    }

    @Test
    void calculate_tax_for_companies() {
        assertTaxToPay(250, new SelfEmployed());
        assertTaxToPay(330, new SAS());
        assertTaxToPay(100, new SARL());
        assertTaxToPay(100, new SASU());
    }

    private void assertTaxToPay(double expectedTaxToPay, Company company) {
        double taxToPay = company.calculateTax(ANNUAL_TURNOVER);

        assertThat(taxToPay).isEqualTo(expectedTaxToPay);
    }
}
